package com.decipline.self.controller;


import com.decipline.self.entities.Book;
import com.decipline.self.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/core/book")
@CrossOrigin("*")
public class BookController {

    private final BookService bookService;

    @PostMapping("/add")
    public Book addBookDetails(@RequestBody Book book){
       return bookService.addBookDetails(book);
    }

    @GetMapping("/view")
    public List<Book> viewAllBooks(){
        return bookService.viewAllBooks();
    }


    @GetMapping("/types")
    public List<String> findAlllBookType(){
        return bookService.getBookTypes();
    }

    @GetMapping("/view/{id}")
    public Book getBook(@PathVariable int id){
        return bookService.getBook(id);
    }
}
