package com.example.commondtos.events;

import com.example.commondtos.dto.OrderRequestDto;
import com.example.commondtos.dto.OrderResponseDto;

import java.util.Date;
import java.util.UUID;

public class OrderEvent implements Event{

    private Date date = new Date();

    private String randomId = UUID.randomUUID().toString();


    private OrderRequestDto orderRequestDto;

    private OrderStatus orderStatus;
    @Override
    public Date getEventDate() {
        return date;
    }

    @Override
    public String getRandomId() {
        return randomId;
    }

    public OrderEvent(OrderRequestDto orderRequestDto,OrderStatus orderStatus){
        this.orderRequestDto = orderRequestDto;
        this.orderStatus = orderStatus;
    }

    public OrderRequestDto getOrderRequestDto() {
        return orderRequestDto;
    }

    public void setOrderRequestDto(OrderRequestDto orderRequestDto) {
        this.orderRequestDto = orderRequestDto;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
