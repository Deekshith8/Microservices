package com.microservicesDemo.OrderService.orderService;


import com.microservicesDemo.OrderService.external.client.BookService;
import com.microservicesDemo.OrderService.orderEntity.orderEntity;
import com.microservicesDemo.OrderService.orderRepository.IorderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class orderServiceImpl implements IorderService {

    @Autowired
    private IorderRepo orderrepo;

    @Autowired
    private BookService bookService;

    @Override
    public ResponseEntity<String> saveOrder(orderEntity order) {


        try{
            System.out.println("hiii");
            bookService.updateNoofBooks(order.getBookId(), order.getNoOfBooksOrdered());
            System.out.println("Hii2");
                    orderrepo.save(order);
            return  new ResponseEntity<>("Order is Succesfull with orderId"+ order.getOrderId(),HttpStatus.CREATED);
        }
        catch(Exception e){
            return  new ResponseEntity<>("Error occured while creating Order ", HttpStatus.BAD_GATEWAY);
        }

    }
}
