package com.finalproject.warehousemanagementsystem.repository;

import com.finalproject.warehousemanagementsystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
