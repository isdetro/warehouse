package com.finalproject.warehousemanagementsystem.controller;

import com.finalproject.warehousemanagementsystem.dto.productWarehouse.ProductWarehouseIUDRequest;
import com.finalproject.warehousemanagementsystem.service.ProductWarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-warehouse")
public class ProductWarehouseController {

    private ProductWarehouseService productWarehouseService;

    public ProductWarehouseController(ProductWarehouseService productWarehouseService) {
        this.productWarehouseService = productWarehouseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<String>> getAllByProductId(Long productId) {
        return ResponseEntity.ok(productWarehouseService.getWarehouseNamesByProductId(productId));
    }

    @PostMapping
    public ResponseEntity<ProductWarehouseIUDRequest> add(
            @RequestBody List<ProductWarehouseIUDRequest> productWarehouseIUDRequestList
    ) {
        productWarehouseService.saveIUDRequest(productWarehouseIUDRequestList);
        return ResponseEntity.ok().build();
    }
}
