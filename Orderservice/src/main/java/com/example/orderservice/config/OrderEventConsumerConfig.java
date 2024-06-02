package com.example.orderservice.config;

import com.example.commondtos.events.PaymentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@Configuration
public class OrderEventConsumerConfig {
    @Autowired
    private OrderStatusUpdateHandler handler;
@Bean
    public Consumer<PaymentEvent>handlePaymentEvent(){
        return (paymentEvent) ->handler.handleOrderStatusUpdate(paymentEvent,(po)-> po.setPaymentStatus(paymentEvent.getPaymentStatus()));
    }

}
