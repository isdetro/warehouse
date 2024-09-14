package com.finalproject.warehousemanagementsystem.dto.category;

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
public class CategoryJdqViewDto {

    @JdqField("id")
    Long id;

    @JdqField("status<name")
    String statusName;

    @JdqField("name")
    String name;

    @JdqField("parentCategory<name")
    String parentCategoryName;

}
