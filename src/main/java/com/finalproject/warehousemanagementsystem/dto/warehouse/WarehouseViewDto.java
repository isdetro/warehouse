package com.finalproject.warehousemanagementsystem.dto.warehouse;

import com.finalproject.warehousemanagementsystem.dto.base.BaseViewDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WarehouseViewDto extends BaseViewDto {

    String name;
    String address;
    String typeName;

}
