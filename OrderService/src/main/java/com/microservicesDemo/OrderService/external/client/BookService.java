package com.microservicesDemo.OrderService.external.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "BOOK-SERVICE/")
public interface BookService {

    @PutMapping("/updateNoOfBooks/{id}")
    ResponseEntity<String> updateNoofBooks(@PathVariable( name = "id")int id, @RequestParam int noOfBooks);
}
