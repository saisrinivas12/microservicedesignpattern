package com.example.commondtos.dto;

public class OrderRequestDto {

    private String orderId;

    private String productId;

    private String userId;

    private double productAmount;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(double productAmount) {
        this.productAmount = productAmount;
    }

    public OrderRequestDto(String orderId, String productId, String userId, double productAmount) {
        this.orderId = orderId;
        this.productId = productId;
        this.userId = userId;
        this.productAmount = productAmount;
    }

    public OrderRequestDto() {
    }
}
