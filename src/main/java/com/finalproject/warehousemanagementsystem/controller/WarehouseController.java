package com.finalproject.warehousemanagementsystem.controller;

import com.finalproject.warehousemanagementsystem.dto.category.CategoryIUDRequest;
import com.finalproject.warehousemanagementsystem.dto.category.CategoryJdqViewDto;
import com.finalproject.warehousemanagementsystem.dto.warehouse.WarehouseIUDRequest;
import com.finalproject.warehousemanagementsystem.dto.warehouse.WarehouseJdqViewDto;
import com.finalproject.warehousemanagementsystem.service.CategoryService;
import com.finalproject.warehousemanagementsystem.service.WarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/warehouses")
public class WarehouseController {

   private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping
    public ResponseEntity<List<WarehouseJdqViewDto>> getAllCategories() {
        return ResponseEntity.ok(warehouseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseJdqViewDto> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(warehouseService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Object> addCategory(@RequestBody List<WarehouseIUDRequest> warehouseIUDRequestList) {
        warehouseService.saveIUDRequest(warehouseIUDRequestList);
        return ResponseEntity.ok().build();
    }
}
