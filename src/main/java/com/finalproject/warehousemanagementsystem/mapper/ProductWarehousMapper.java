package com.finalproject.warehousemanagementsystem.mapper;

import com.finalproject.warehousemanagementsystem.dto.productWarehouse.ProductWarehouseIUDRequest;
import com.finalproject.warehousemanagementsystem.model.ProductWarehouse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductWarehousMapper {

    ProductWarehouse fromIUDRequestToDbo(ProductWarehouseIUDRequest from);

    List<ProductWarehouse> fromIUDRequestToDbo(List<ProductWarehouseIUDRequest> from);
}
