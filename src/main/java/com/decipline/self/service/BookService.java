package com.decipline.self.service;

import com.decipline.self.entities.Book;
import com.decipline.self.repo.BookRepo;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;

    public Book addBookDetails(Book book){
        if (book != null){
            if (StringUtils.isNotBlank(book.getNewBookType())){
                book.setBookType(book.getNewBookType());
            }
            return bookRepo.save(book);
        }
        return null;
    }

    public List<Book> viewAllBooks(){
        return bookRepo.findAll();
    }

    public List<String> getBookTypes(){
        return bookRepo.findAllBookType();
    }

}
