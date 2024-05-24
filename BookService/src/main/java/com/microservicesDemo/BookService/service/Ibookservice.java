package com.microservicesDemo.BookService.service;

import com.microservicesDemo.BookService.Entity.BookEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Ibookservice {
    List<BookEntity> getAllAvailableBooks();

    ResponseEntity<Integer> saveBook(BookEntity book);

    ResponseEntity<HttpStatus> updateBook(int id,BookEntity book);

    ResponseEntity<HttpStatus> deleteBookById(int id);

    ResponseEntity<String> updateNoofBooks(int id, int noOfBooks);
}
