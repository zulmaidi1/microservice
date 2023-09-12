package com.zulmaidi.orderservice.controller;

import com.zulmaidi.orderservice.dto.OrderRequest;
import com.zulmaidi.orderservice.dto.OrderResponse;
import com.zulmaidi.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        path = "/api/orders"
)
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse create(@RequestBody OrderRequest request){
        return orderService.placeOrder(request);
    }
}
