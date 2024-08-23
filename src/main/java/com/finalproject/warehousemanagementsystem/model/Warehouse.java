package com.finalproject.warehousemanagementsystem.model;

import com.finalproject.warehousemanagementsystem.base.BaseEntityAudit;
import com.finalproject.warehousemanagementsystem.base.TypeofWarehouse;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "Warehouses")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Warehouse extends BaseEntityAudit {

    @Nationalized
    @Column(nullable = false)
    String name;

    @Nationalized
    @Column(nullable = false)
    String address;

    @Column(name = "type_id", nullable = false)
    Long typeId;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false, insertable = false, updatable = false)
    TypeofWarehouse typeofWarehouse;
}
