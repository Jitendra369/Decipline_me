package com.decipline.self;

import com.decipline.self.entities.Book;
import com.decipline.self.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeciplineYourselfApplicationTests {

	@Autowired
	private BookService bookService;

	@Test
	void contextLoads() {
	}

	@Test
	void testBooks(){
		Book book = new Book();
		book.setBookName("essentialism");
		book.setAuthorName("howitzer");
		bookService.addBookDetails(book);
	}

}
