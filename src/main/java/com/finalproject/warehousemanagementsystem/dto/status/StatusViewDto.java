package com.finalproject.warehousemanagementsystem.dto.status;

import com.finalproject.warehousemanagementsystem.dto.base.BaseViewDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatusViewDto extends BaseViewDto {

    String name;

}
