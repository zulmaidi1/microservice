package com.zulmaidi.productservice.service;

import com.zulmaidi.productservice.dto.ProductRequest;
import com.zulmaidi.productservice.dto.ProductResponse;
import com.zulmaidi.productservice.model.Product;

import java.util.List;

public interface ProductService {
     List<ProductResponse> gets();
    ProductResponse create(ProductRequest product);
    ProductResponse get(String id);
    ProductResponse update(ProductRequest product, String id);
    void delete(String id);

    ProductResponse findBySkuCode(String sku);


}
