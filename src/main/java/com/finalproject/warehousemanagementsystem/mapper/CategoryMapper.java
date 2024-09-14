package com.finalproject.warehousemanagementsystem.mapper;

import com.finalproject.warehousemanagementsystem.dto.category.CategoryIUDRequest;
import com.finalproject.warehousemanagementsystem.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    Category fromIUDRequestToDbo(CategoryIUDRequest from);

    List<Category> fromIUDRequestToDbo(List<CategoryIUDRequest> from);

}
