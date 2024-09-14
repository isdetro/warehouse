package com.finalproject.warehousemanagementsystem.dto.location;

import com.beyt.jdq.annotation.model.JdqField;
import com.beyt.jdq.annotation.model.JdqModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@JdqModel
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationJdqViewDto {

    @JdqField(value = "id")
    Long id;

    @JdqField(value = "city")
    String city;

    @JdqField(value = "country")
    String country;

    @JdqField(value = "streetAddress")
    String streetAddress;

    @JdqField(value = "status<name")
    String statusName;

}
