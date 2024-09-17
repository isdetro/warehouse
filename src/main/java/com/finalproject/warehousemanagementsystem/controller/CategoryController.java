package com.finalproject.warehousemanagementsystem.controller;

import com.finalproject.warehousemanagementsystem.dto.category.CategoryIUDRequest;
import com.finalproject.warehousemanagementsystem.dto.category.CategoryJdqViewDto;
import com.finalproject.warehousemanagementsystem.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryJdqViewDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryJdqViewDto> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Object> addCategory(@RequestBody List<CategoryIUDRequest> categoryIUDRequests) {
        categoryService.saveIUDRequest(categoryIUDRequests);
        return ResponseEntity.ok().build();
    }
}
