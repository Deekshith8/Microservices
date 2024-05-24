package com.microservicesDemo.OrderService.orderEntity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "orderdb")
public class orderEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    private  int userId;

    private int bookId;

    private Instant ordertime;

    private int noOfBooksOrdered;

    public orderEntity() {
    }

    public orderEntity(int userId, int bookId, Instant ordertime, int noOfBooksOrdered) {
        this.userId = userId;
        this.bookId = bookId;
        this.ordertime = ordertime;
        this.noOfBooksOrdered = noOfBooksOrdered;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getNoOfBooksOrdered() {
        return noOfBooksOrdered;
    }

    public void setNoOfBooksOrdered(int noOfBooksOrdered) {
        this.noOfBooksOrdered = noOfBooksOrdered;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Instant getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Instant ordertime) {
        this.ordertime = ordertime;
    }
}
