package com.bookshare.bookshare.service.impl;

import com.bookshare.bookshare.model.Book;
import com.bookshare.bookshare.repositories.BookRepository;
import com.bookshare.bookshare.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    @Override
    public List<Book> getBooksByAuthorOrName(String authorOrName) {
        Optional<Book> books = bookRepository.findAllByNameBookOrAuthorBook(authorOrName);
        return books.stream().toList();
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findBookById(id);
    }
}
