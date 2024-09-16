package com.finalproject.warehousemanagementsystem.repository;

import com.beyt.jdq.repository.JpaDynamicQueryRepository;
import com.finalproject.warehousemanagementsystem.model.Product;

public interface ProductRepository extends JpaDynamicQueryRepository<Product, Long> {
}
