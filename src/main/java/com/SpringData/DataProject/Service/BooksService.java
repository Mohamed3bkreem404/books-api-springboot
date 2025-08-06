package com.SpringData.DataProject.Service;

import com.SpringData.DataProject.Model.BooksModel;
import com.SpringData.DataProject.Repository.BooksRepo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class BooksService {

    private final BooksRepo booksRepo;
    private final EmailService emailService;
    private final MessageSource messageSource;

    public BooksService(BooksRepo booksRepo, EmailService emailService, MessageSource messageSource) {
        this.booksRepo = booksRepo;
        this.emailService = emailService;
        this.messageSource = messageSource;
    }

    @Cacheable("AllBooks")
    public Page<BooksModel> getBooks(String author, String title, Integer year, Pageable pageable) {
        return booksRepo.searchBooks(author, title, year, pageable);
    }

    @Caching(
            put = @CachePut(value = "books", key = "#savedBook.id"),
            evict = @CacheEvict(value = "AllBooks", allEntries = true)
    )
    public String addBooks(BooksModel booksModel, Locale locale) {
        BooksModel savedBook = booksRepo.save(booksModel);
        emailService.sendEmailToUser();
        Locale effectiveLocale = (locale != null) ? locale : Locale.ENGLISH;
        return messageSource.getMessage("book.add.success", null, effectiveLocale);
    }

    @Caching(
            evict = {
                    @CacheEvict(value = "books", key = "#book.id"),
                    @CacheEvict(value = "AllBooks", allEntries = true)
            }
    )
    public void deleteBook(BooksModel book) {
        booksRepo.delete(book);
    }
}
