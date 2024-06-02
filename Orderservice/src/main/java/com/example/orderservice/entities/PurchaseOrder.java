package com.example.orderservice.entities;

import com.example.commondtos.events.OrderStatus;
import com.example.commondtos.events.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PURCHASE_ORDER_TABLE")
public class PurchaseOrder {
    @Id
    private String orderId;

    private String userId;

    private String productId;

    private double productPrice;
    @Enumerated
    private OrderStatus orderStatus;
    @Enumerated
    private PaymentStatus paymentStatus;


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

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PurchaseOrder(String orderId, String userId, String productId, double productPrice, OrderStatus orderStatus, PaymentStatus paymentStatus) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.productPrice = productPrice;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
    }

    public PurchaseOrder(){}
}
