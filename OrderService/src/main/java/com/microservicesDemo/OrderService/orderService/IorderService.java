package com.microservicesDemo.OrderService.orderService;

import com.microservicesDemo.OrderService.orderEntity.orderEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface IorderService {
    ResponseEntity<String> saveOrder(orderEntity order);
}
