package com.SpringData.DataProject.Controller;

import com.SpringData.DataProject.Model.BooksModel;
import com.SpringData.DataProject.Service.BooksService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping
public class BooksController {

        @Autowired
        BooksService booksService;

        //To get book/s parameters can be sended on or two or all of them .
        @GetMapping("/getBooks")
        public Page<BooksModel> getBooks(
                 @RequestParam(required = false) String author,

                 @RequestParam(required = false) String title,

                 @RequestParam(required = false) Integer year,
                Pageable pageable
                ){
            return  booksService.getBooks(author, title, year , pageable);
        }

        //To add anybook u want .

        @PostMapping("/addBooks")
        public void addBooks(@RequestBody  BooksModel book) {
                 booksService.addBooks(book);
        }

        @PostMapping("/deleteBook")
        public void deleteBook(@RequestBody BooksModel booksModel){
                booksService.deleteBook(booksModel);
        }


}
