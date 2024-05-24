package com.microservicesDemo.BookService.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="bookdb")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;



    private String bookName;


    private int  numberOfBooks;

    public BookEntity() {
    }

    public BookEntity(String bookName, int numberOfBooks) {
        this.bookName = bookName;
        this.numberOfBooks = numberOfBooks;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }
}
