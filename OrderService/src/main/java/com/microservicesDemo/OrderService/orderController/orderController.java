package com.microservicesDemo.OrderService.orderController;


import com.microservicesDemo.OrderService.orderEntity.orderEntity;
import com.microservicesDemo.OrderService.orderService.IorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/")
public class orderController {

    @Autowired
    private IorderService iorderService;

    @PostMapping("/order")
    public ResponseEntity<String> saveOrder(@RequestBody orderEntity order){
       order.setOrdertime(Instant.now());
       return  iorderService.saveOrder(order);

    }



}
