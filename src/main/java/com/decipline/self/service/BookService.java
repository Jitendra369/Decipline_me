package com.decipline.self.service;

import com.decipline.self.entities.Book;
import com.decipline.self.repo.BookRepo;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
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

    public Book getBook(int id ){
        Optional<Book> bookOptional = bookRepo.findById(id);
        if (bookOptional.isPresent()){
            return bookOptional.get();
        }else{
            log.error("book with id : "+ id+" is not present");
            return null;
        }
    }

}
