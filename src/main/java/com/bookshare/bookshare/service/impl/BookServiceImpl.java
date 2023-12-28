package com.bookshare.bookshare.service.impl;

import com.bookshare.bookshare.exeptions.ResourceNotFoundException;
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
    public Optional<Book> getBooksByAuthorOrName(String authorOrName) {
        return bookRepository.findAllByNameBookOrAuthorBook(authorOrName);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findBookById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Книга с id " + id + " не найдена"));
    }

    @Override
    public void updateBook(Book book, Long id) {
        Book book1 = bookRepository.findBookById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Книга с id " + id + " не найдена"
        ));
        book1.setAuthorBook(book.getAuthorBook());
        book1.setNameBook(book.getNameBook());
        book1.setDescription(book.getDescription());
        book1.setImageUrl(book.getImageUrl());
        bookRepository.save(book1);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
