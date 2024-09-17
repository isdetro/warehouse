package com.finalproject.warehousemanagementsystem.service;

import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.CriteriaList;
import com.beyt.jdq.dto.DynamicQuery;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.finalproject.warehousemanagementsystem.dto.base.ModuleKeys;
import com.finalproject.warehousemanagementsystem.dto.base.RedisKeyDto;
import com.finalproject.warehousemanagementsystem.dto.warehouse.WarehouseIUDRequest;
import com.finalproject.warehousemanagementsystem.dto.warehouse.WarehouseJdqViewDto;
import com.finalproject.warehousemanagementsystem.mapper.WarehouseMapper;
import com.finalproject.warehousemanagementsystem.model.Warehouse;
import com.finalproject.warehousemanagementsystem.repository.WarehouseRepository;
import com.finalproject.warehousemanagementsystem.util.Messages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper warehouseMapper;
    private final RedisTemplate<String, Object> redisTemplate;

    public WarehouseService(WarehouseRepository warehouseRepository, WarehouseMapper warehouseMapper, RedisTemplate<String, Object> redisTemplate) {
        this.warehouseRepository = warehouseRepository;
        this.warehouseMapper = warehouseMapper;
        this.redisTemplate = redisTemplate;
    }

    public WarehouseJdqViewDto getById(Long id) {
        RedisKeyDto redisKeyDto = new RedisKeyDto();
        redisKeyDto.setId(id);
        redisKeyDto.setKey(ModuleKeys.WAREHOUSE.getName());

        WarehouseJdqViewDto warehouseJdqViewDto =
                (WarehouseJdqViewDto) redisTemplate.opsForValue().get(redisKeyDto.toString());

        if (warehouseJdqViewDto != null) {
            log.info(Messages.DATA_FROM_CACHE_MESSAGE);
            return warehouseJdqViewDto;
        }

        DynamicQuery dynamicQuery = new DynamicQuery();
        dynamicQuery.setWhere(CriteriaList.of(Criteria.of("id", CriteriaOperator.EQUAL, id)));
        List<WarehouseJdqViewDto> list = warehouseRepository.findAll(dynamicQuery, WarehouseJdqViewDto.class);

        if (list != null && !list.isEmpty()) {
            log.info(Messages.DATA_FROM_REPO_MESSAGE);
            return list.get(0);
        }

        return null;

    }

    public List<WarehouseJdqViewDto> getAll() {
        DynamicQuery dynamicQuery = new DynamicQuery();
        List<WarehouseJdqViewDto> list = warehouseRepository.findAll(dynamicQuery, WarehouseJdqViewDto.class);
        if (list != null && !list.isEmpty()) {
            return list;
        }

        return new ArrayList<>();
    }

    public Long save(Warehouse warehouse) {
        return warehouseRepository.save(warehouse).getId();
    }

    public void saveIUDRequest(List<WarehouseIUDRequest> warehouseIUDRequestList) {
        if (warehouseIUDRequestList != null && !warehouseIUDRequestList.isEmpty()) {
            for (WarehouseIUDRequest warehouseIUDRequest : warehouseIUDRequestList) {
                Long id = save(warehouseMapper.fromIUDRequestToDbo(warehouseIUDRequest));

                RedisKeyDto redisKeyDto = new RedisKeyDto();
                redisKeyDto.setId(id);
                redisKeyDto.setKey(ModuleKeys.WAREHOUSE.getName());

                WarehouseJdqViewDto warehouseJdqViewDto =
                        (WarehouseJdqViewDto) redisTemplate.opsForValue().get(redisKeyDto.toString());

                if (warehouseJdqViewDto != null) {
                    log.info(Messages.UPDATE_CACHE_DATA_MESSAGE);
                    redisTemplate.delete(redisKeyDto.toString());
                }
                WarehouseJdqViewDto warehouseJdqViewDtoNew = getById(id);
                redisTemplate.opsForValue().set(redisKeyDto.toString(), warehouseJdqViewDtoNew);
            }
        }
    }
}
