package com.finalproject.warehousemanagementsystem.dto.product;

import com.beyt.jdq.annotation.model.JdqField;
import com.beyt.jdq.annotation.model.JdqIgnoreField;
import com.beyt.jdq.annotation.model.JdqModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@JdqModel
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductJdqViewDto {

    @JdqField("id")
    Long id;

    @JdqField("name")
    String name;

    @JdqField("purchasePrice")
    BigDecimal purchasePrice;

    @JdqField("sellingPrice")
    BigDecimal sellingPrice;

    @JdqField("category<name")
    String subcategoryName;

    @JdqIgnoreField
    List<String> warehouseNameList;
}
