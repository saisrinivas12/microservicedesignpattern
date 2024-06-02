package com.example.orderservice.config;

import com.example.commondtos.dto.OrderRequestDto;
import com.example.commondtos.dto.OrderResponseDto;
import com.example.commondtos.events.OrderEvent;
import com.example.commondtos.events.OrderStatus;
import com.example.commondtos.events.PaymentEvent;
import com.example.commondtos.events.PaymentStatus;
import com.example.orderservice.entities.PurchaseOrder;
import com.example.orderservice.repository.PurchaseOrderRepository;
import com.example.orderservice.service.OrderStatusPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class OrderStatusUpdateHandler {
@Autowired
private PurchaseOrderRepository purchaseOrderRepository;
@Autowired
private OrderStatusPublisher publisher;
    public void handleOrderStatusUpdate(PaymentEvent paymentEvent , Consumer<PurchaseOrder>order){
      String orderId = paymentEvent.getPaymentRequestDto().getOrderId();
      purchaseOrderRepository.findById(orderId).ifPresent(order.andThen(this::updateOrderStatus));
    }

    private void updateOrderStatus(PurchaseOrder purchaseOrder) {
      boolean isPaymentCompleted = purchaseOrder.getPaymentStatus().equals(PaymentStatus.PAYMENT_SUCCESSFUL)?true:false;
        OrderStatus orderStatus = isPaymentCompleted?OrderStatus.ORDER_COMPLETED:OrderStatus.ORDER_CANCELLED;
        purchaseOrder.setOrderStatus(orderStatus);
        if(!isPaymentCompleted){
            publisher.publishOrderEvent(convertEntityToDto(purchaseOrder),orderStatus);
        }
    }

    private OrderRequestDto convertEntityToDto(PurchaseOrder purchaseOrder){
        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setOrderId(purchaseOrder.getOrderId());
        orderRequestDto.setUserId(purchaseOrder.getUserId());
        orderRequestDto.setProductId(purchaseOrder.getProductId());
        orderRequestDto.setProductAmount(purchaseOrder.getProductPrice());
        return orderRequestDto;
    }
}
