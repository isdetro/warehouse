package com.finalproject.warehousemanagementsystem.dto.productWarehouse;

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
public class WarehouseByProductJdqViewDto {

    @JdqField("warehouse<name")
    String warehouseName;

}
