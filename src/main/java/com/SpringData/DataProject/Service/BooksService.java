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
        System.out.println("Cashhh is workking");
        return booksRepo.searchBooks(author, title, year, pageable);
    }

    @CachePut(value = "books", key = "#book.id")
    public BooksModel saveBook(BooksModel book) {
        return booksRepo.save(book);
    }

    public String addBooks(BooksModel book, Locale locale) {
        BooksModel savedBook = saveBook(book);
        emailService.sendEmailToUser();
        return messageSource.getMessage("book.add.success", null, locale != null ? locale : Locale.ENGLISH);
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
