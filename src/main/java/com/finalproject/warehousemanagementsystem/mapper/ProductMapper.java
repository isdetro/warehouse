package com.finalproject.warehousemanagementsystem.mapper;

import com.finalproject.warehousemanagementsystem.dto.product.ProductIUDRequest;
import com.finalproject.warehousemanagementsystem.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    Product fromIUDRequestToDbo(ProductIUDRequest from);

    List<Product> fromIUDRequestToDbo(List<ProductIUDRequest> from);

}
