package com.finalproject.warehousemanagementsystem.dto.location;

import com.finalproject.warehousemanagementsystem.util.Messages;
import com.finalproject.warehousemanagementsystem.util.NotNullAndNotBlank;
import jakarta.persistence.Column;
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
public class LocationIUDRequest {

    Long id;

    @NotNullAndNotBlank(message = "City " + Messages.NOT_NULL_MESSAGE)
    String city;
    @NotNullAndNotBlank(message = "Country " + Messages.NOT_NULL_MESSAGE)
    String country;
    @NotNullAndNotBlank(message = "Street " + Messages.NOT_NULL_MESSAGE)
    String streetAddress;
    @NotNull(message = Messages.STATUS_NOT_NULL_MESSAGE)
    Long statusId;

}
