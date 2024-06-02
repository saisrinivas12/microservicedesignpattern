package com.example.commondtos.dto;

import com.example.commondtos.events.OrderStatus;

public class OrderResponseDto {


    private String orderId;

    private String userId;

    private String productId;

    private double productAmount;


    private OrderStatus status;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(double productAmount) {
        this.productAmount = productAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderResponseDto(String orderId, String userId, String productId, double productAmount, OrderStatus status) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.productAmount = productAmount;
        this.status = status;
    }

    public OrderResponseDto(){

    }
}
