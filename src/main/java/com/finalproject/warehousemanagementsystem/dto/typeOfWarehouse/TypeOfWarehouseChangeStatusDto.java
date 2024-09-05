package com.finalproject.warehousemanagementsystem.dto.typeOfWarehouse;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.finalproject.warehousemanagementsystem.util.LongDeserializer;
import com.finalproject.warehousemanagementsystem.util.Messages;
import javax.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeOfWarehouseChangeStatusDto {

    @JsonDeserialize(using = LongDeserializer.class)
    Long id;
    @JsonDeserialize(using = LongDeserializer.class)
    Long statusId;

}
