package com.decipline.self.entities;

import com.decipline.self.annotations.DefaultValueAnno;
import jakarta.annotation.PostConstruct;
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

    @DefaultValueAnno(value = "new Books")
    private String bookType;

    private String bookReview;

    @Transient
    private String newBookType;

    @Column(name = "is_read")
    private Boolean readDone;

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct init method called");
    }

}
