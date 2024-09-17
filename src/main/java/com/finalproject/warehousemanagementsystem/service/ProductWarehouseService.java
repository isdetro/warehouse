package com.finalproject.warehousemanagementsystem.service;

import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.CriteriaList;
import com.beyt.jdq.dto.DynamicQuery;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.finalproject.warehousemanagementsystem.dto.base.ModuleKeys;
import com.finalproject.warehousemanagementsystem.dto.base.RedisKeyDto;
import com.finalproject.warehousemanagementsystem.dto.productWarehouse.ProductWarehouseIUDRequest;
import com.finalproject.warehousemanagementsystem.dto.productWarehouse.WarehouseByProductJdqViewDto;
import com.finalproject.warehousemanagementsystem.mapper.ProductWarehousMapper;
import com.finalproject.warehousemanagementsystem.model.ProductWarehouse;
import com.finalproject.warehousemanagementsystem.repository.ProductWarehouseRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductWarehouseService {

    private final ProductWarehouseRepository productWarehouseRepository;
    private final ProductWarehousMapper productWarehousMapper;
    private final RedisTemplate<String, Object> redisTemplate;

    public ProductWarehouseService(
            ProductWarehouseRepository productWarehouseRepository,
            ProductWarehousMapper productWarehousMapper,
            RedisTemplate<String, Object> redisTemplate
    ) {
        this.productWarehouseRepository = productWarehouseRepository;
        this.productWarehousMapper = productWarehousMapper;
        this.redisTemplate = redisTemplate;
    }

    public List<String> getWarehouseNamesByProductId(Long productId) {
        DynamicQuery dynamicQuery = new DynamicQuery();
        dynamicQuery.setWhere(CriteriaList.of(Criteria.of("productId", CriteriaOperator.EQUAL, productId)));
        List<WarehouseByProductJdqViewDto> list =
                productWarehouseRepository.findAll(dynamicQuery, WarehouseByProductJdqViewDto.class);

        if (list != null && !list.isEmpty()) {
            List<String> warehouseNames = new ArrayList<>();
            for (WarehouseByProductJdqViewDto dto : list) {
                warehouseNames.add(dto.getWarehouseName());
            }
            return warehouseNames;
        }
        return new ArrayList<>();
    }

    public Long save(ProductWarehouse productWarehouse) {
        return productWarehouseRepository.save(productWarehouse).getId();
    }


    @Transactional
    public void saveIUDRequest(List<ProductWarehouseIUDRequest> productWarehouseIUDRequestList) {
        RedisKeyDto redisKeyDto = new RedisKeyDto();
        redisKeyDto.setKey(ModuleKeys.PRODUCT.getName());

        if (productWarehouseIUDRequestList != null && !productWarehouseIUDRequestList.isEmpty()) {
            productWarehouseIUDRequestList.forEach(productWarehouse -> {
                redisKeyDto.setId(productWarehouse.getProductId());
                redisTemplate.delete(redisKeyDto.toString());
                save(productWarehousMapper.fromIUDRequestToDbo(productWarehouse));
            });
        }

    }
}
