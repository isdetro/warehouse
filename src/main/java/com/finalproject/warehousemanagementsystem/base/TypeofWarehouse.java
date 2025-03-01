package com.finalproject.warehousemanagementsystem.base;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "TypesOfWarehouse")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class TypeofWarehouse extends BaseEntityAudit {

    String name;

    public TypeofWarehouse(Long id, String name, Long statusId) {
        super.setId(id);
        super.setStatusId(statusId);
        this.name = name;
    }

}
