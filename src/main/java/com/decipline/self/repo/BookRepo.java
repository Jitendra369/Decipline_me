package com.decipline.self.repo;

import com.decipline.self.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Integer> {

    @Query("SELECT DISTINCT b.bookType FROM Book b")
    List<String> findAllBookType();
}
