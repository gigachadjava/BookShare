package com.bookshare.bookshare.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name_book")
    private String nameBook;

    @Column(name = "author_book")
    private String authorBook;

    @Column(name = "image_url")
    private String imageUrl;

    @Column
    private String description;

    @Basic
    private LocalDateTime postTime;

    @PrePersist
    public void prePersist() {
        postTime = LocalDateTime.now();
    }
}
