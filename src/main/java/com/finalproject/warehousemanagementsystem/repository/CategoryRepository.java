package com.finalproject.warehousemanagementsystem.repository;

import com.finalproject.warehousemanagementsystem.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
