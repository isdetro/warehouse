package com.finalproject.warehousemanagementsystem.controller;

import com.finalproject.warehousemanagementsystem.base.TypeofWarehouse;
import com.finalproject.warehousemanagementsystem.dto.typeOfWarehouse.TypeOfWarehouseChangeStatusDto;
import com.finalproject.warehousemanagementsystem.dto.typeOfWarehouse.TypeOfWarehouseViewDto;
import com.finalproject.warehousemanagementsystem.service.TypeOfWarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/types-of-warehouse")
public class TypeOfWarehouseController {

    private final TypeOfWarehouseService typeOfWarehouseService;

    public TypeOfWarehouseController(TypeOfWarehouseService typeOfWarehouseService) {
        this.typeOfWarehouseService = typeOfWarehouseService;
    }

    @GetMapping
    public List<TypeofWarehouse> getAllTypeOfWarehouse() {
        return typeOfWarehouseService.getAll();
    }

    @GetMapping("/{id}")
    public TypeOfWarehouseViewDto getTypeOfWarehouseById(@PathVariable Long id) {
        return typeOfWarehouseService.getById(id);
    }

    @PostMapping("/{id}/change-status")
    public ResponseEntity<Object> changeStatusOfWarehouse(@PathVariable Long id, @RequestParam Long statusId) {
        System.out.println("------------");
        TypeOfWarehouseChangeStatusDto typeOfWarehouse = new TypeOfWarehouseChangeStatusDto(id,statusId);
        System.out.println(typeOfWarehouse.getId());
        System.out.println(typeOfWarehouse.getStatusId());
        typeOfWarehouseService.changeStatus(typeOfWarehouse);
        return ResponseEntity.ok(typeOfWarehouse);
    }
}
