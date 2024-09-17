package com.finalproject.warehousemanagementsystem.dto.warehouse;

import com.beyt.jdq.annotation.model.JdqField;
import com.beyt.jdq.annotation.model.JdqModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@JdqModel
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WarehouseJdqViewDto {

    @JdqField("id")
    Long id;

    @JdqField("status<name")
    String statusName;

    @JdqField("name")
    String name;

    @JdqField("typeofWarehouse<name")
    String typeName;

    @JdqField("location<city")
    String city;

    @JdqField("location<country")
    String country;

    @JdqField("location<streetAddress")
    String streetAddress;

}
