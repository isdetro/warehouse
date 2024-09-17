package com.finalproject.warehousemanagementsystem.dto.warehouse;

import com.finalproject.warehousemanagementsystem.util.Messages;
import com.finalproject.warehousemanagementsystem.util.NotNullAndNotBlank;
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
public class WarehouseIUDRequest {

    Long id;

    @NotNullAndNotBlank(message = Messages.NAME_NOT_NULL_MESSAGE)
    String name;

    @NotNull(message = Messages.REQUIRED_FIELDS_NOT_NULL_MESSAGE)
    Long locationId;

    @NotNull(message = Messages.REQUIRED_FIELDS_NOT_NULL_MESSAGE)
    Long typeId;

    @NotNull(message = Messages.REQUIRED_FIELDS_NOT_NULL_MESSAGE)
    Long statusId;

}
