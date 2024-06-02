package com.example.paymentservice.service;

import com.example.commondtos.dto.OrderRequestDto;
import com.example.commondtos.dto.PaymentRequestDto;
import com.example.commondtos.events.OrderEvent;
import com.example.commondtos.events.PaymentEvent;
import com.example.commondtos.events.PaymentStatus;
import com.example.paymentservice.entities.UserBalance;
import com.example.paymentservice.entities.UserTransaction;
import com.example.paymentservice.repository.UserBalanceRepository;
import com.example.paymentservice.repository.UserTransactionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PaymentServiceImpl {

    @Autowired
    private UserTransactionRepository userTransactionRepository;
    @Autowired
    private UserBalanceRepository userBalanceRepository;
    @PostConstruct
    public void initBalanceValues(){
        List<UserBalance>userBalances = Stream.of(new UserBalance("101","saisrinivas",10000.00),
                new UserBalance("102","karthik",20000.00)).collect(Collectors.toList());
        userBalanceRepository.saveAll(userBalances);
    }
    public PaymentEvent handlePayment(OrderEvent orderEvent){
        OrderRequestDto orderRequestDto = orderEvent.getOrderRequestDto();
        PaymentRequestDto paymentRequestDto = new PaymentRequestDto(orderRequestDto.getUserId(),orderRequestDto.getProductId(),
                orderRequestDto.getOrderId(),orderRequestDto.getProductAmount(), PaymentStatus.PAYMENT_INITIATED);
        return userBalanceRepository.findById(orderRequestDto.getUserId()).
                filter(ub -> ub.getBankBalance() > paymentRequestDto.getProductAmount())
                .map(ub -> {
                    ub.setBankBalance(ub.getBankBalance() - paymentRequestDto.getProductAmount());
                    userTransactionRepository.save(new UserTransaction(UUID.randomUUID().toString(),ub.getUserId(),orderRequestDto.getOrderId(),orderRequestDto.getProductId(),PaymentStatus.PAYMENT_SUCCESSFUL));
                    paymentRequestDto.setPaymentStatus(PaymentStatus.PAYMENT_SUCCESSFUL);
                    return new PaymentEvent(paymentRequestDto,PaymentStatus.PAYMENT_SUCCESSFUL);
                }).orElseGet(()->{
                    paymentRequestDto.setPaymentStatus(PaymentStatus.PAYMENT_CANCELLED);
                    return new PaymentEvent(paymentRequestDto,PaymentStatus.PAYMENT_CANCELLED);
                });
    }

    public PaymentEvent cancelOrder(OrderEvent orderEvent){
        OrderRequestDto orderRequestDto = orderEvent.getOrderRequestDto();
        PaymentRequestDto paymentRequestDto = new PaymentRequestDto(orderRequestDto.getUserId(),orderRequestDto.getProductId(),
                orderRequestDto.getOrderId(),orderRequestDto.getProductAmount(), PaymentStatus.PAYMENT_CANCELLED);
        return userBalanceRepository.findById(orderRequestDto.getUserId())
                .map((ub)-> {
                    userTransactionRepository.save(new UserTransaction(UUID.randomUUID().toString(),ub.getUserId(), orderRequestDto.getOrderId(), orderRequestDto.getProductId(), PaymentStatus.PAYMENT_CANCELLED));
                    return new PaymentEvent(paymentRequestDto,PaymentStatus.PAYMENT_CANCELLED);
                })
                .orElse(new PaymentEvent(paymentRequestDto,PaymentStatus.PAYMENT_CANCELLED));

    }
}
