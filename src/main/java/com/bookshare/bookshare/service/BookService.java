package com.bookshare.bookshare.service;

import com.bookshare.bookshare.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> getBooksByAuthorOrName(String authorOrName);
    List<Book> getAllBook();

    Book getById(Long id);

    void updateBook(Book book, Long id);

    Book save(Book book);
}
