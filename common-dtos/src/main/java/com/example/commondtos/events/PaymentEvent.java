package com.example.commondtos.events;

import com.example.commondtos.dto.PaymentRequestDto;

import java.util.Date;
import java.util.UUID;

public class PaymentEvent implements Event{

    private Date date = new Date();
    private String randomId = UUID.randomUUID().toString();

    private PaymentRequestDto paymentRequestDto;

    private PaymentStatus paymentStatus;


    @Override
    public Date getEventDate() {
        return date;
    }

    @Override
    public String getRandomId() {
        return randomId;
    }

    public PaymentEvent(PaymentRequestDto paymentRequestDto,PaymentStatus paymentStatus){
        this.paymentRequestDto = paymentRequestDto;
        this.paymentStatus = paymentStatus;
    }

    public PaymentRequestDto getPaymentRequestDto() {
        return paymentRequestDto;
    }

    public void setPaymentRequestDto(PaymentRequestDto paymentRequestDto) {
        this.paymentRequestDto = paymentRequestDto;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
