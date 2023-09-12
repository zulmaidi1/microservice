package com.zulmaidi.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLineResponse {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
    private ProductResponse product;
}
