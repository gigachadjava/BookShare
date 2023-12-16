package com.bookshare.bookshare.controllers;

import com.bookshare.bookshare.model.Book;
import com.bookshare.bookshare.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/book")
public class BookController {
    private final BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> bookList = bookService.getAllBook();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> getBookByParam(@RequestParam String param) {
        List<Book> bookList = bookService.getBooksByAuthorOrName(param);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
}
