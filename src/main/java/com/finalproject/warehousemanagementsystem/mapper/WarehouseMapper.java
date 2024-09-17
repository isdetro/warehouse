package com.finalproject.warehousemanagementsystem.mapper;

import com.finalproject.warehousemanagementsystem.dto.warehouse.WarehouseIUDRequest;
import com.finalproject.warehousemanagementsystem.model.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WarehouseMapper {

    Warehouse fromIUDRequestToDbo(WarehouseIUDRequest from);

    List<Warehouse> fromIUDRequestToDbo(List<WarehouseIUDRequest> from);

}
