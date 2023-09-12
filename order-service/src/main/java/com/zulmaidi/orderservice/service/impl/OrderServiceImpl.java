package com.zulmaidi.orderservice.service.impl;

import com.zulmaidi.orderservice.dto.OrderLineRequest;
import com.zulmaidi.orderservice.dto.OrderRequest;
import com.zulmaidi.orderservice.model.Order;
import com.zulmaidi.orderservice.model.OrderLineItem;
import com.zulmaidi.orderservice.repository.OrderRepository;
import com.zulmaidi.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public String placeOrder(OrderRequest request) {
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderLineItems(request.getOrderLineRequests().stream().map(this::toOrderLineItem).toList())
                .build();
        orderRepository.save(order);

        return "Order placed successfully";
    }

    private OrderLineItem toOrderLineItem(OrderLineRequest item){
        return  OrderLineItem.builder()
                .skuCode(item.getSkuCode())
                .quantity(item.getQuantity())
                .price(item.getPrice())
                .build();
    }
}
