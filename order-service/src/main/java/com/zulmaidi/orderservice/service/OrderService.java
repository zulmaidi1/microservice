package com.zulmaidi.orderservice.service;

import com.zulmaidi.orderservice.dto.OrderRequest;

public interface OrderService {
    String placeOrder(OrderRequest request);

}
