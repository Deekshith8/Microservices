package com.microservicesDemo.BookService.repository;

import com.microservicesDemo.BookService.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IbookRepository extends JpaRepository<BookEntity,Integer> {

    @Query(value = "Select * from bookdb",nativeQuery = true)
    List<BookEntity> getAllAvailableBooks();
}
