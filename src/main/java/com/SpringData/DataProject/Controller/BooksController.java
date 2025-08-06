package com.SpringData.DataProject.Controller;

import com.SpringData.DataProject.Model.BooksModel;
import com.SpringData.DataProject.Service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Locale;

@Validated
@RestController
@RequestMapping("/api/books")
public class BooksController {

        @Autowired
        BooksService booksService;

        @GetMapping("/getBooks")
        public Page<BooksModel> getBooks(
                @RequestParam(required = false) String author,
                @RequestParam(required = false) String title,
                @RequestParam(required = false) Integer year,
                Pageable pageable
        ) {
                return booksService.getBooks(author, title, year, pageable);
        }

        @PostMapping("/addBooks")
        public String addBooks(@Valid @RequestBody BooksModel book,
                               @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
                return booksService.addBooks(book, locale);
        }

        @PostMapping("/deleteBook")
        public void deleteBook(@Valid @RequestBody BooksModel booksModel) {
                booksService.deleteBook(booksModel);
        }
}
