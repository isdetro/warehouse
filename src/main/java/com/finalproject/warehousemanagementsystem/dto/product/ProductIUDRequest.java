package com.finalproject.warehousemanagementsystem.dto.product;

import com.finalproject.warehousemanagementsystem.util.Messages;
import com.finalproject.warehousemanagementsystem.util.NotNullAndNotBlank;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductIUDRequest {

    Long id;

    @NotNullAndNotBlank(message = Messages.NAME_NOT_NULL_MESSAGE)
    String name;
    @NotNull(message = "Purchase Price " + Messages.NOT_NULL_MESSAGE)
    BigDecimal purchasePrice;
    @NotNull(message = "Selling Price " + Messages.NOT_NULL_MESSAGE)
    BigDecimal sellingPrice;
    @NotNull(message = "Subcategory " + Messages.NOT_NULL_MESSAGE)
    Long subcategoryId;
    @NotNull(message = Messages.STATUS_NOT_NULL_MESSAGE)
    Long statusId;
}
