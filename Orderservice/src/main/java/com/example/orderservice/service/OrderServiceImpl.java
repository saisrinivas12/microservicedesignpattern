package com.example.orderservice.service;

import com.example.commondtos.dto.OrderRequestDto;
import com.example.commondtos.events.OrderStatus;
import com.example.orderservice.entities.PurchaseOrder;
import com.example.orderservice.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl {
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

   @Autowired
    private OrderStatusPublisher orderStatusPublisher;
@Transactional
    public PurchaseOrder saveOrder(OrderRequestDto orderRequestDto){
        PurchaseOrder purchaseOrder = convertDtoToEntity(orderRequestDto);
        //SAVE to the database with order created and then publish an event to kafka so that payment service
        // got subscribed will process the event
        purchaseOrderRepository.save(purchaseOrder);
        orderStatusPublisher.publishOrderEvent(orderRequestDto,OrderStatus.ORDER_CREATED);
        return purchaseOrder;
    }

    public List<PurchaseOrder>getAllOrders(){
        return purchaseOrderRepository.findAll();
    }

    private PurchaseOrder convertDtoToEntity(OrderRequestDto orderRequestDto) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setOrderId(orderRequestDto.getOrderId());
        purchaseOrder.setUserId(orderRequestDto.getUserId());
        purchaseOrder.setProductId(orderRequestDto.getProductId());
        purchaseOrder.setProductPrice(orderRequestDto.getProductAmount());
        purchaseOrder.setOrderStatus(OrderStatus.ORDER_CREATED);
        return purchaseOrder;
    }
}
