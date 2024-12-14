package com.decipline.self.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bookName;

    private String authorName;

    private String bookType;

    private String bookReview;

    @Transient
    private String newBookType;

    @Column(name = "is_read")
    private Boolean readDone;

}
