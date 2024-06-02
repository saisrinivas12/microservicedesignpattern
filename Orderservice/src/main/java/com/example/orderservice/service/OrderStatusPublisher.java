package com.example.orderservice.service;

import com.example.commondtos.dto.OrderRequestDto;
import com.example.commondtos.events.OrderEvent;
import com.example.commondtos.events.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Sinks;
@Service
public class OrderStatusPublisher {

    @Autowired
    private Sinks.Many<OrderEvent>sinks;

    public void publishOrderEvent(OrderRequestDto orderRequestDto, OrderStatus orderStatus){
        OrderEvent orderEvent = new OrderEvent(orderRequestDto,orderStatus);
        System.out.println("transferring data to the payment service");
        sinks.tryEmitNext(orderEvent);
    }


}
