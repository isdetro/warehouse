package com.finalproject.warehousemanagementsystem.dto.category;

import com.finalproject.warehousemanagementsystem.dto.base.BaseViewDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryViewDto extends BaseViewDto {

    String name;
    String parentCategoryName;

}
