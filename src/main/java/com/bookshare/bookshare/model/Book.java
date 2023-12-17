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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nameBook")
    private String nameBook;

    @Column(name = "authorBook")
    private String authorBook;

    @Column
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
