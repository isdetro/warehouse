package com.finalproject.warehousemanagementsystem.dto.product;

import com.finalproject.warehousemanagementsystem.dto.base.BaseViewDto;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductViewDto extends BaseViewDto {

    String name;
    BigDecimal purchasePrice;
    BigDecimal sellingPrice;
    String subcategoryName;
    String warehouseName;

}
