package com.finalproject.warehousemanagementsystem.service;

import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.CriteriaList;
import com.beyt.jdq.dto.DynamicQuery;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.finalproject.warehousemanagementsystem.dto.base.ModuleKeys;
import com.finalproject.warehousemanagementsystem.dto.base.RedisKeyDto;
import com.finalproject.warehousemanagementsystem.dto.product.ProductJdqViewDto;
import com.finalproject.warehousemanagementsystem.mapper.ProductMapper;
import com.finalproject.warehousemanagementsystem.repository.ProductRepository;
import com.finalproject.warehousemanagementsystem.util.Messages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductWarehouseService productWarehouseService;
    private final ProductMapper productMapper;
    private final RedisTemplate<String, Object> redisTemplate;

    public ProductService(
            ProductRepository productRepository,
            ProductWarehouseService productWarehouseService,
            ProductMapper productMapper,
            RedisTemplate<String, Object> redisTemplate
    ) {
        this.productRepository = productRepository;
        this.productWarehouseService = productWarehouseService;
        this.productMapper = productMapper;
        this.redisTemplate = redisTemplate;
    }

    public ProductJdqViewDto getById(Long id) {
        RedisKeyDto redisKeyDto = new RedisKeyDto();
        redisKeyDto.setKey(ModuleKeys.PRODUCT.getName());
        redisKeyDto.setId(id);

        ProductJdqViewDto productJdqViewDto =
                (ProductJdqViewDto) redisTemplate.opsForValue().get(redisKeyDto.toString());

        if (productJdqViewDto != null) {
            log.info(Messages.DATA_FROM_CACHE_MESSAGE);
            return productJdqViewDto;
        }


        DynamicQuery dynamicQuery = new DynamicQuery();
        dynamicQuery.setWhere(CriteriaList.of(Criteria.of("id", CriteriaOperator.EQUAL, id)));
        List<ProductJdqViewDto> list = productRepository.findAll(dynamicQuery, ProductJdqViewDto.class);
        if (list != null && !list.isEmpty()) {
            log.info(Messages.DATA_FROM_REPO_MESSAGE);
            redisTemplate.opsForValue().set(redisKeyDto.toString(), list.get(0));

            return list.get(0);
        }
        return null;
    }

    public List<ProductJdqViewDto> getAll() {
        DynamicQuery dynamicQuery = new DynamicQuery();
        List<ProductJdqViewDto> list = productRepository.findAll(dynamicQuery, ProductJdqViewDto.class);
        if (list != null && !list.isEmpty()) {
            return list;
        }
        return new ArrayList<>();
    }

}
