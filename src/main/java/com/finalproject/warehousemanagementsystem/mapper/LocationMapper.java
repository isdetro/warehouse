package com.finalproject.warehousemanagementsystem.mapper;

import com.finalproject.warehousemanagementsystem.dto.location.LocationIUDRequest;
import com.finalproject.warehousemanagementsystem.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationMapper {

    Location fromIUDRequestToDbo(LocationIUDRequest from);

    List<Location> fromIUDRequestToDbo(List<LocationIUDRequest> from);
}
