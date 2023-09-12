package com.zulmaidi.inventoryservice.controller;

import com.zulmaidi.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @GetMapping("/sku/{skuCode}")
    public boolean isInStock(@PathVariable(name = "skuCode") String skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
