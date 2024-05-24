package com.microservicesDemo.OrderService.orderRepository;

import com.microservicesDemo.OrderService.orderEntity.orderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IorderRepo extends JpaRepository<orderEntity,Integer> {
}
