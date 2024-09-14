package com.finalproject.warehousemanagementsystem.service;

import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.CriteriaList;
import com.beyt.jdq.dto.DynamicQuery;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.finalproject.warehousemanagementsystem.dto.base.ModuleKeys;
import com.finalproject.warehousemanagementsystem.dto.base.RedisKeyDto;
import com.finalproject.warehousemanagementsystem.dto.category.CategoryIUDRequest;
import com.finalproject.warehousemanagementsystem.dto.category.CategoryJdqViewDto;
import com.finalproject.warehousemanagementsystem.mapper.CategoryMapper;
import com.finalproject.warehousemanagementsystem.model.Category;
import com.finalproject.warehousemanagementsystem.repository.CategoryRepository;
import com.finalproject.warehousemanagementsystem.util.Messages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final RedisTemplate<String, Object> redisTemplate;

    public CategoryService(
            CategoryRepository categoryRepository,
            CategoryMapper categoryMapper,
            RedisTemplate<String, Object> redisTemplate
    ) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.redisTemplate = redisTemplate;
    }

    public CategoryJdqViewDto getById(Long id) {
        RedisKeyDto redisKeyDto = new RedisKeyDto();
        redisKeyDto.setId(id);
        redisKeyDto.setKey(ModuleKeys.CATEGORY.getName());

        CategoryJdqViewDto categoryJdqViewDto =
                (CategoryJdqViewDto) redisTemplate.opsForValue().get(redisKeyDto.toString());
        if (categoryJdqViewDto != null) {
            log.info(Messages.DATA_FROM_CACHE_MESSAGE);
            return categoryJdqViewDto;
        }

        DynamicQuery dynamicQuery = new DynamicQuery();
        dynamicQuery.setWhere(CriteriaList.of(Criteria.of("id", CriteriaOperator.EQUAL, id)));
        List<CategoryJdqViewDto> result = categoryRepository.findAll(dynamicQuery, CategoryJdqViewDto.class);
        if (result != null && !result.isEmpty()) {
            log.info(Messages.DATA_FROM_REPO_MESSAGE);
            redisTemplate.opsForValue().set(redisKeyDto.toString(), result.get(0));
            return result.get(0);
        }
        return null;
    }


    public List<CategoryJdqViewDto> getAll() {
        DynamicQuery dynamicQuery = new DynamicQuery();
        List<CategoryJdqViewDto> list = categoryRepository.findAll(dynamicQuery, CategoryJdqViewDto.class);
        if (list != null && !list.isEmpty()) {
            return list;
        }
        return new ArrayList<>();
    }


    public Long save(Category category) {
        return categoryRepository.save(category).getId();
    }

    public void saveIUDRequest(List<CategoryIUDRequest> categoryIUDRequestList) {
        if (categoryIUDRequestList != null && !categoryIUDRequestList.isEmpty()) {
            for (CategoryIUDRequest categoryIUDRequest : categoryIUDRequestList) {
                Long id = save(categoryMapper.fromIUDRequestToDbo(categoryIUDRequest));

                RedisKeyDto redisKeyDto = new RedisKeyDto();
                redisKeyDto.setKey(ModuleKeys.CATEGORY.getName());
                redisKeyDto.setId(id);

              CategoryJdqViewDto categoryJdqViewDto =
                      (CategoryJdqViewDto) redisTemplate.opsForValue().get(redisKeyDto.toString());

              if (categoryJdqViewDto != null) {
                  log.info(Messages.UPDATE_CACHE_DATA_MESSAGE);
                  redisTemplate.delete(redisKeyDto.toString());
              }

              CategoryJdqViewDto categoryJdqViewDtoNew = getById(id);
              redisTemplate.opsForValue().set(redisKeyDto.toString(), categoryJdqViewDtoNew);
            }
        }

    }

}
