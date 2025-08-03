package com.SpringData.DataProject.Service;
import com.SpringData.DataProject.Model.BooksModel;
import com.SpringData.DataProject.Repository.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BooksService {

    @Autowired
    BooksRepo booksRepo;



    @Cacheable("AllBooks")
    public Page<BooksModel> getBooks(String author, String title, Integer year , Pageable pageable){
//        Testing if cache is working or not :3
//        System.out.println("⛏⛏⛏⛏ Fetching from DB...");
        return booksRepo.searchBooks(author,title,year , pageable);

    }

    @Caching(
            put = @CachePut(value = "books" , key = "#book.id"),
            evict = @CacheEvict(value = "AllBooks", allEntries = true)
    )
    public void addBooks(BooksModel book) {
              booksRepo.save(book);

    }

    @Caching(
            evict = {
                    @CacheEvict(value = "books" , key = "#booksModel.id"),
                    @CacheEvict(value = "AllBooks",allEntries = true)
            }
    )
    public void deleteBook(BooksModel booksModel) {
            booksRepo.delete(booksModel);
    }
}
