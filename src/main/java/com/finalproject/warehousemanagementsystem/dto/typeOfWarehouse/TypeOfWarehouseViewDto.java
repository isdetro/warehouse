package com.finalproject.warehousemanagementsystem.dto.typeOfWarehouse;

import com.finalproject.warehousemanagementsystem.dto.base.BaseViewDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeOfWarehouseViewDto extends BaseViewDto {

    String name;

}
