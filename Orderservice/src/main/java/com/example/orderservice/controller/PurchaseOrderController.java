package com.example.orderservice.controller;

import com.example.commondtos.dto.OrderRequestDto;
import com.example.orderservice.entities.PurchaseOrder;
import com.example.orderservice.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class PurchaseOrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @PostMapping("/saveOrder")
    public ResponseEntity<PurchaseOrder> createOrder(@RequestBody OrderRequestDto orderRequestDto){
        PurchaseOrder order = orderService.saveOrder(orderRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<PurchaseOrder>> getAllOrders(){
        List<PurchaseOrder>orders = orderService.getAllOrders();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orders);
    }


}
