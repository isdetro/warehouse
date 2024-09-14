package com.finalproject.warehousemanagementsystem.service;

import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.CriteriaList;
import com.beyt.jdq.dto.DynamicQuery;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.finalproject.warehousemanagementsystem.dto.category.CategoryIUDRequest;
import com.finalproject.warehousemanagementsystem.dto.category.CategoryJdqViewDto;
import com.finalproject.warehousemanagementsystem.mapper.CategoryMapper;
import com.finalproject.warehousemanagementsystem.model.Category;
import com.finalproject.warehousemanagementsystem.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    public List<CategoryJdqViewDto> getAllCategories() {
        DynamicQuery dynamicQuery = new DynamicQuery();
        return categoryRepository.findAll(dynamicQuery, CategoryJdqViewDto.class);
    }

    public CategoryJdqViewDto getCategoryById(Long id) {
        DynamicQuery dynamicQuery = new DynamicQuery();
        dynamicQuery.setWhere(CriteriaList.of(Criteria.of("id", CriteriaOperator.EQUAL, id)));
        List<CategoryJdqViewDto> result = categoryRepository.findAll(dynamicQuery, CategoryJdqViewDto.class);
        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    public Long saveCategory(Category category) {
        return categoryRepository.save(category).getId();
    }

    public void saveIUDRequest(List<CategoryIUDRequest> categoryIUDRequestList) {
        categoryIUDRequestList.forEach(categoryIUDRequest -> {
            if (categoryIUDRequest.getId() == null) {
                Category category = categoryMapper.fromIUDRequestToDbo(categoryIUDRequest);
                saveCategory(category);
            } else {
                Category category = categoryMapper.fromIUDRequestToDbo(categoryIUDRequest);
                saveCategory(category);
            }
        });

    }

}
