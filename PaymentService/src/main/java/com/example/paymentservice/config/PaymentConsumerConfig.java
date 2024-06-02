package com.example.paymentservice.config;

import com.example.commondtos.events.OrderEvent;
import com.example.commondtos.events.OrderStatus;
import com.example.commondtos.events.PaymentEvent;
import com.example.paymentservice.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;
@Configuration
public class PaymentConsumerConfig {
@Autowired
    private PaymentServiceImpl paymentService;
@Bean
    public Function<Flux<OrderEvent>,Flux<PaymentEvent>>getOrderEventAndProcess(){
        return (orderEventFlux -> orderEventFlux.flatMap(this::handleOrderEvent));
    }

    public Mono<PaymentEvent> handleOrderEvent(OrderEvent orderEvent){
        if(OrderStatus.ORDER_CREATED.equals(orderEvent.getOrderStatus())){
           return Mono.fromSupplier(() -> paymentService.handlePayment(orderEvent));
        }
        return Mono.fromSupplier(()-> paymentService.cancelOrder(orderEvent));

    }
}
