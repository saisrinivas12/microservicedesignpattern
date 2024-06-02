package com.example.orderservice.config;

import com.example.commondtos.events.OrderEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

@Configuration
public class PublisherConfig {

    @Bean
    public Sinks.Many<OrderEvent> sinks() {
        return Sinks.many().multicast().onBackpressureBuffer();
    }
@Bean//acts as publisher
    public Supplier<Flux<OrderEvent>> orderEventSupplier(Sinks.Many<OrderEvent> sinks) {
        return sinks::asFlux;
    }
}
