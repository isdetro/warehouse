package com.finalproject.warehousemanagementsystem.dto.typeOfWarehouse;

import com.finalproject.warehousemanagementsystem.util.Messages;
import com.finalproject.warehousemanagementsystem.util.NotNullAndNotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeOfWarehouseIUDRequest {

    @NotNullAndNotBlank(message = Messages.NAME_NOT_NULL_MESSAGE)
    String name;
    @NotNull(message = Messages.STATUS_NOT_NULL_MESSAGE)
    Long statusId;
}
