package com.finalproject.warehousemanagementsystem.controller;

import com.finalproject.warehousemanagementsystem.dto.product.ProductIUDRequest;
import com.finalproject.warehousemanagementsystem.dto.product.ProductJdqViewDto;
import com.finalproject.warehousemanagementsystem.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductJdqViewDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductJdqViewDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Object> addProduct(@RequestBody List<ProductIUDRequest> productIUDRequestList) {
        productService.saveIUDRequest(productIUDRequestList);
        return ResponseEntity.ok().build();
    }
}
