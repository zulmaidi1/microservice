package com.zulmaidi.inventoryservice.controller;

import com.zulmaidi.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    public boolean isInStock(@PathVariable(name = "sku-code") String skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
