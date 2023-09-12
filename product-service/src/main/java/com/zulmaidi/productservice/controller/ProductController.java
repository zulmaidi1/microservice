package com.zulmaidi.productservice.controller;

import com.zulmaidi.productservice.dto.ProductRequest;
import com.zulmaidi.productservice.dto.ProductResponse;
import com.zulmaidi.productservice.model.Product;
import com.zulmaidi.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = "/api/products",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public List<ProductResponse> gets(){
        return productService.gets();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse save(@RequestBody ProductRequest request){
        return productService.create(request);
    }

    @PutMapping(
            path = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ProductResponse update(@RequestBody ProductRequest request, @PathVariable(name = "id") String id){
        return productService.update(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable(name = "id") String id){
        productService.delete(id);
        return "OK";
    }

    @GetMapping("/sku/{skuCode}")
    public ProductResponse findBySkuCode(@PathVariable(name = "skuCode") String skuCode){
        return productService.findBySkuCode(skuCode);
    }
}
