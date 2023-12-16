package com.bookshare.bookshare.service;

import com.bookshare.bookshare.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooksByAuthorOrName(String authorOrName);
    List<Book> getAllBook();

    Book getById(Long id);
}
