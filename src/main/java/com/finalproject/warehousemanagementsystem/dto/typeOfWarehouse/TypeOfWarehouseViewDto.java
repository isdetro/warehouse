package com.finalproject.warehousemanagementsystem.dto.typeOfWarehouse;

import com.finalproject.warehousemanagementsystem.dto.base.BaseViewDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeOfWarehouseViewDto extends BaseViewDto implements Serializable {

    String name;

}
