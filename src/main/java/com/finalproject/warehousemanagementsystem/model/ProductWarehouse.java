package com.finalproject.warehousemanagementsystem.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "ProductWarehouse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductWarehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "product_id", nullable = false)
    Long productId;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false, nullable = false)
    Product product;

    @Column(name = "warehouse_id", nullable = false)
    Long warehouseId;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", insertable = false, updatable = false, nullable = false)
    Warehouse warehouse;
}
