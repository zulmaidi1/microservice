package com.zulmaidi.productservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String skuCode;
    @NotBlank
    private String description;
    @NotNull
    private BigDecimal price;
}
