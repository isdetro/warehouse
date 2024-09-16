package com.finalproject.warehousemanagementsystem.dto.productWarehouse;

import com.finalproject.warehousemanagementsystem.util.Messages;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductWarehouseIUDRequest {

    Long id;

    @NotNull(message = Messages.REQUIRED_FIELDS_NOT_NULL_MESSAGE)
    Long productId;

    @NotNull(message = Messages.REQUIRED_FIELDS_NOT_NULL_MESSAGE)
    Long warehouseId;

}
