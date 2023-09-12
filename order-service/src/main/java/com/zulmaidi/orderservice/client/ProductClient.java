package com.zulmaidi.orderservice.client;

import com.zulmaidi.orderservice.dto.ProductResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface ProductClient {
    @GetExchange("/api/products/sku/{skuCode}")
    public ProductResponse findBySkuCode(@PathVariable(name = "skuCode") String skuCode);
}
