package com.zulmaidi.productservice.repository;

import com.zulmaidi.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findFistBySkuCode(String skuCode);
}
