package com.microservicesDemo.BookService.controller;


import com.microservicesDemo.BookService.Entity.BookEntity;
import com.microservicesDemo.BookService.service.Ibookservice;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class bookController {


    @Autowired
    private Ibookservice bookservice;


     @GetMapping("/books")
    public ResponseEntity<List<BookEntity>> getAllAvailableBooks(){

         List<BookEntity>books=bookservice.getAllAvailableBooks();

         return new ResponseEntity<>(books, HttpStatus.OK);
     }


     @PostMapping("/saveBook")
    public ResponseEntity<Integer>saveBook(@RequestBody BookEntity book){
         System.out.println(book.getBookName());
        return  bookservice.saveBook(book);
     }

     @PutMapping("/updateBook/{id}")
    public ResponseEntity<HttpStatus>updateBook(@PathVariable int id,@RequestBody BookEntity book){
         return bookservice.updateBook(id,book);
     }


     @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<HttpStatus>deleteBookById(@PathVariable int id){
         return  bookservice.deleteBookById(id);
     }


     @PutMapping("/updateNoOfBooks/{id}")
    public ResponseEntity<String> updateNoofBooks(@PathVariable(name = "id")int id, @RequestParam int noOfBooks){
         System.out.println("in controller");
         return bookservice.updateNoofBooks(id,noOfBooks);
     }


}
