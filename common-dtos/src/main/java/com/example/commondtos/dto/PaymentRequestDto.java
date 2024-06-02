package com.example.commondtos.dto;

import com.example.commondtos.events.PaymentStatus;

public class PaymentRequestDto {

    private String userId;

    private String productId;

    private String orderId;

    private double productAmount;


    private PaymentStatus paymentStatus;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(double productAmount) {
        this.productAmount = productAmount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentRequestDto(String userId, String productId, String orderId, double productAmount, PaymentStatus paymentStatus) {
        this.userId = userId;
        this.productId = productId;
        this.orderId = orderId;
        this.productAmount = productAmount;
        this.paymentStatus = paymentStatus;
    }

    public PaymentRequestDto(){}
}
