package com.finalproject.warehousemanagementsystem.model;

import com.finalproject.warehousemanagementsystem.base.BaseEntityAudit;
import com.finalproject.warehousemanagementsystem.base.TypeofWarehouse;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Warehouses")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Warehouse extends BaseEntityAudit {

    @Column(nullable = false)
    String name;

    @Column(name = "location_id",nullable = false)
    Long locationId;

    @ManyToOne
    @JoinColumn(name = "location_id", insertable = false, updatable = false, nullable = false)
    Location location;

    @Column(name = "type_id", nullable = false)
    Long typeId;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false, insertable = false, updatable = false)
    TypeofWarehouse typeofWarehouse;
}
