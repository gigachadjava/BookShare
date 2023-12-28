package com.bookshare.bookshare.controllers;

import com.bookshare.bookshare.exeptions.ApiException;
import com.bookshare.bookshare.exeptions.ResourceNotFoundException;
import com.bookshare.bookshare.model.Book;
import com.bookshare.bookshare.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("api/book")
@Tag(name = "Книги", description = "Информация о книгах")
public class BookController {
    private final BookService bookService;

    @GetMapping("/{id}")
    @Operation(description = "Информация о книге")
    public Book getBookById(
            @Parameter(description = "Id книги")
            @PathVariable Long id) {
        return bookService.getById(id);
    }

    @GetMapping
    @Operation(description = "Информация о всех книгах")
    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> bookList = bookService.getAllBook();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/search")
    @Operation(description = "Поиск книги по названию книги или автора")
    public ResponseEntity<?> getBookByParam(
            @Parameter(description = "Имя автора или книги")
            @RequestParam String param) {
        Optional<Book> bookList = bookService.getBooksByAuthorOrName(param);
        if (bookList.isEmpty()) {
            return new ResponseEntity<>("Нет результатов", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
    @PostMapping
    @Operation(description = "Добавить книгу")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public void updateBook(
            @PathVariable Long id,
            @RequestBody Book book) {
        bookService.updateBook(book, id);
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiException handleException(ResourceNotFoundException e) {
        return new ApiException(
                e.getMessage(),
                e.getBadRequest(),
                e,
                ZonedDateTime.now()
        );
    }
}
