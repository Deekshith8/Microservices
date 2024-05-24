package com.microservicesDemo.BookService.service;


import com.microservicesDemo.BookService.Entity.BookEntity;
import com.microservicesDemo.BookService.repository.IbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class bookServiceImpl implements Ibookservice{

    @Autowired
    private IbookRepository bookRepository;


    @Override
    public List<BookEntity> getAllAvailableBooks() {
        List<BookEntity> books=bookRepository.getAllAvailableBooks();

        return books;
    }

    @Override
    public ResponseEntity<Integer> saveBook(BookEntity book) {
        bookRepository.save(book);

        return new ResponseEntity<>(book.getBookId(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<HttpStatus> updateBook(int id,BookEntity book) {
        BookEntity temp=bookRepository.findById(id).get();

        if(temp!=null){
            temp.setBookName(book.getBookName());
            temp.setNumberOfBooks(book.getNumberOfBooks());
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteBookById(int id) {

        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        return  new  ResponseEntity<>(HttpStatus.BAD_REQUEST);


//        BookEntity book = bookRepository.findById(id).
//                orElse(return new ResponseEntity<>(HttpStatus.BAD_REQUEST));
//
//       if(book != null){
//            bookRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }

    }

    @Override
    public ResponseEntity<String> updateNoofBooks(int id, int noOfBooks) {
        System.out.println(id);
        if(bookRepository.existsById(id)){

            BookEntity book=bookRepository.findById(id).get();
            if(book.getNumberOfBooks()<noOfBooks){
                return new ResponseEntity<>("Available Books "+book.getNumberOfBooks(),HttpStatus.BAD_REQUEST);
            }
            book.setNumberOfBooks(book.getNumberOfBooks()-noOfBooks);
            bookRepository.save(book);
            return  new ResponseEntity<>("Success", HttpStatus.OK);

        }
        else{
            return new ResponseEntity<>("Book not found with id: "+id,HttpStatus.NOT_FOUND);
        }

    }
}
