package com.zulmaidi.orderservice.service;

import com.zulmaidi.orderservice.dto.OrderRequest;
import com.zulmaidi.orderservice.dto.OrderResponse;
import com.zulmaidi.orderservice.dto.ProductResponse;

import java.util.List;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest request);

    List<ProductResponse> gets();

}
