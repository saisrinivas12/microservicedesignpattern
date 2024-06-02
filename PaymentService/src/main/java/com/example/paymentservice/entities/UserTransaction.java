package com.example.paymentservice.entities;

import com.example.commondtos.events.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USER_TRANSACTION_TABLE")
public class UserTransaction {
@Id
    private String transactionId;

    private String userId;

    private String orderId;

    private String price;
@Enumerated
    private PaymentStatus paymentStatus;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public UserTransaction(String transactionId, String userId, String orderId, String price, PaymentStatus paymentStatus) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.orderId = orderId;
        this.price = price;
        this.paymentStatus = paymentStatus;
    }

    public UserTransaction(){}
}
