package com.zulmaidi.orderservice.service.impl;

import com.zulmaidi.orderservice.client.ProductClient;
import com.zulmaidi.orderservice.dto.*;
import com.zulmaidi.orderservice.model.Order;
import com.zulmaidi.orderservice.model.OrderLineItem;
import com.zulmaidi.orderservice.repository.OrderRepository;
import com.zulmaidi.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    ProductClient productClient;
    @Override
    public OrderResponse placeOrder(OrderRequest request) {
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderLineItems(request.getOrderLineRequests().stream().map(this::toOrderLineItem).toList())
                .build();
        order = orderRepository.saveAndFlush(order);

        return toProductResponse(order);
    }

    @Override
    public List<ProductResponse> gets() {
        return null;
    }

    private OrderLineItem toOrderLineItem(OrderLineRequest item){
        return  OrderLineItem.builder()
                .skuCode(item.getSkuCode())
                .quantity(item.getQuantity())
                .price(item.getPrice())
                .build();
    }

    private OrderResponse toProductResponse(Order order){
        return OrderResponse.builder()
                .id(order.getId())
                .orderNumber(order.getOrderNumber())
                .orderItems(order.getOrderLineItems().stream().map(
                        (item) -> OrderLineResponse.builder()
                                .id(item.getId())
                                .skuCode(item.getSkuCode())
                                .price(item.getPrice())
                                .quantity(item.getQuantity())
                                .product(productClient.findBySkuCode(item.getSkuCode()))
                                .build()
                ).toList())
                .build();
    }


}
