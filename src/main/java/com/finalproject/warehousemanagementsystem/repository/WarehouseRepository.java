package com.finalproject.warehousemanagementsystem.repository;

import com.finalproject.warehousemanagementsystem.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
