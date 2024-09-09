package com.finalproject.warehousemanagementsystem.service;

import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.finalproject.warehousemanagementsystem.base.TypeofWarehouse;
import com.finalproject.warehousemanagementsystem.dto.typeOfWarehouse.TypeOfWarehouseChangeStatusDto;
import com.finalproject.warehousemanagementsystem.dto.typeOfWarehouse.TypeOfWarehouseViewDto;
import com.finalproject.warehousemanagementsystem.repository.TypeOfWarehouseRepository;
import com.finalproject.warehousemanagementsystem.util.Messages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.beyt.jdq.query.builder.QuerySimplifier.Select;

@Service
@Slf4j
public class TypeOfWarehouseService {

    private final TypeOfWarehouseRepository typeOfWarehouseRepository;
    private final CacheManager cacheManager;

    public TypeOfWarehouseService(TypeOfWarehouseRepository typeOfWarehouseRepository, CacheManager cacheManager) {
        this.typeOfWarehouseRepository = typeOfWarehouseRepository;
        this.cacheManager = cacheManager;
    }

    public TypeOfWarehouseViewDto getById(Long id) {
        Cache cache = cacheManager.getCache("typewarehouse");
        TypeOfWarehouseViewDto typeOfWarehouseViewDto = cache.get(id, TypeOfWarehouseViewDto.class);
        if (typeOfWarehouseViewDto != null) {
            log.info(Messages.DATA_FROM_CACHE_MESSAGE);
            return typeOfWarehouseViewDto;
        }

        var list = typeOfWarehouseRepository.queryBuilder()
                .select(
                       Select("id"),
                        Select("name"),
                        Select("status<name", "statusName")

                )
                .where(Criteria.of("id", CriteriaOperator.EQUAL, id))
                .getResult(TypeOfWarehouseViewDto.class);

        if (list != null && list.size() > 0) {
            log.info(Messages.DATA_FROM_REPO_MESSAGE);
            cache.put(id, list.get(0));
            return list.get(0);
        }

        return null;
    }

    public List<TypeofWarehouse> getAll() {
        return typeOfWarehouseRepository.findAll();
    }

    public void changeStatus(TypeOfWarehouseChangeStatusDto typeOfWarehouseChangeStatusDto) {
        typeOfWarehouseRepository
                .changeStatus(
                        typeOfWarehouseChangeStatusDto.getId(),
                        typeOfWarehouseChangeStatusDto.getStatusId()
                );
    }
}
