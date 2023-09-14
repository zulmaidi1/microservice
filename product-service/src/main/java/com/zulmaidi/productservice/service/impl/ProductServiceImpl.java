package com.zulmaidi.productservice.service.impl;

import com.zulmaidi.productservice.dto.ProductRequest;
import com.zulmaidi.productservice.dto.ProductResponse;
import com.zulmaidi.productservice.model.Product;
import com.zulmaidi.productservice.repository.ProductRepository;
import com.zulmaidi.productservice.service.ProductService;
import com.zulmaidi.productservice.service.ValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ValidationService validationService;
    @Override
    public List<ProductResponse> gets() {
        return productRepository.findAll().stream().map(this::toProductResponse).toList();
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        validationService.validate(request);
        Product product = Product.builder()
                .name(request.getName())
                .skuCode(request.getSkuCode())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();

         productRepository.save(product);
         log.info("Product {} is saved", product.getId());
         return toProductResponse(product);
    }

    @Override
    public ProductResponse get(String id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "product not found")
        );
        return toProductResponse(product);
    }

    @Override
    public ProductResponse update(ProductRequest request, String id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "product not found")
        );

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());

        productRepository.save(product);
        return toProductResponse(product);
    }

    @Override
    public void delete(String id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "product not found")
        );

        productRepository.delete(product);
    }

    @Override
    public ProductResponse findBySkuCode(String sku) {
        Product product = productRepository.findFistBySkuCode(sku).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "product not found"));

        return toProductResponse(product);
    }

    private ProductResponse toProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .skuCode(product.getSkuCode())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
