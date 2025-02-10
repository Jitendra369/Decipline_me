package com.decipline.self.aspect;

import com.decipline.self.entities.Book;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeSaveBookEntity {

    @Before("execution(* com.decipline.self.service.BookService.addBookDetails(com.decipline.self.entities.Book)) && args(book)")
    public void beforeSave(Book book){
        if (book == null){
            System.out.println("book is null");
        }
        System.out.println("aspect calling before the save method ");
        System.out.println(book);
    }
}
