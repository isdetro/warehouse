package com.finalproject.warehousemanagementsystem.dto.location;

import com.finalproject.warehousemanagementsystem.dto.base.BaseViewDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationViewDto extends BaseViewDto {

    String city;
    String country;
    String streetAddress;

}
