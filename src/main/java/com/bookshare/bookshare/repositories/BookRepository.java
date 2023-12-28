package com.bookshare.bookshare.repositories;

import com.bookshare.bookshare.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findBookById(Long id);

    List<Book> findAll();

    @Query("select b from Book b where lower(b.authorBook) like lower(concat('%', :param, '%')) " +
            "or lower(b.nameBook) like lower(concat('%', :param, '%'))")
    Optional<Book> findAllByNameBookOrAuthorBook(@Param("param") String authorOrName);

}
