package com.finalproject.warehousemanagementsystem.dto.warehouse;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WarehouseIUDRequest {
    Long id;
    String name;
    String address;
    Long typeId;
    Long statusId;

}
