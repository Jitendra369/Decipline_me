package com.decipline.self.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class ReadHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "pages_read")
    private Integer pagesRead;

    @CreationTimestamp
    private String createdDate;

    @Column(name = "is_new_activity")
    private Boolean new_act;
}
