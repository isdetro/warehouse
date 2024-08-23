package com.finalproject.warehousemanagementsystem.dto.status;


import com.finalproject.warehousemanagementsystem.util.Messages;
import com.finalproject.warehousemanagementsystem.util.NotNullAndNotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatusIUDRequest {

    @NotNullAndNotBlank(message = Messages.NAME_NOT_NULL_MESSAGE)
    String name;

}
