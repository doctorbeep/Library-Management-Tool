package com.management.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String author;

    private String ISBN;

    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "library_id")
    @JsonBackReference
    private Library library;

    public Book(String title, String author, String ISBN, Library library, LocalDate releaseDate ) {
        this.id = id;
        this.library = library;
        this.releaseDate = releaseDate;
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
    }
}
