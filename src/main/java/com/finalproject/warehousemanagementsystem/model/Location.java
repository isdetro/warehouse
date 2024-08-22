package com.finalproject.warehousemanagementsystem.model;

import com.finalproject.warehousemanagementsystem.base.BaseEntityAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Locations")
public class Location extends BaseEntityAudit {

    @Column(name = "city", nullable = false)
    String city;

    @Column(name = "country", nullable = false)
    String country;

    @Column(name = "street_address", nullable = false)
    String streetAddress;

}
