package com.finalproject.warehousemanagementsystem.model;

import com.finalproject.warehousemanagementsystem.base.BaseEntityAudit;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@Table(name = "Products")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Product extends BaseEntityAudit {

    @Column(nullable = false)
    String name;

    @Column(name = "purchase_price", nullable = false)
    BigDecimal purchasePrice;

    @Column(name = "selling_price", nullable = false)
    BigDecimal sellingPrice;

    @Column(name = "subcategory_id", nullable = false )
    Long subcategoryId;

    @Column(name = "warehouse_id")
    Long warehouseId;

    @ManyToOne
    @JoinColumn(name = "subcategory_id", nullable = false, insertable = false, updatable = false)
    Category category;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", insertable = false, updatable = false)
    Warehouse warehouse;
}
