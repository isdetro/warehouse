package com.finalproject.warehousemanagementsystem.service;

import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.finalproject.warehousemanagementsystem.dto.status.StatusViewDto;
import com.finalproject.warehousemanagementsystem.repository.StatusRepository;
import com.finalproject.warehousemanagementsystem.util.Messages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.beyt.jdq.query.builder.QuerySimplifier.Select;

@Service
@Slf4j
public class StatusService {

    private final StatusRepository statusRepository;
    private final CacheManager cacheManager;

    public StatusService(StatusRepository statusRepository, CacheManager cacheManager) {
        this.statusRepository = statusRepository;
        this.cacheManager = cacheManager;
    }

    public StatusViewDto getStatus(Long id) {
        Cache cache = cacheManager.getCache ("status");
        StatusViewDto statusViewDto = cache.get(id, StatusViewDto.class);
        if (statusViewDto != null) {
            log.info(Messages.DATA_FROM_CACHE_MESSAGE);
            return statusViewDto;
        }
        var list = statusRepository
                .queryBuilder()
                .select(
                        Select("id"),
                        Select("name")
                )
                .where(Criteria.of("id", CriteriaOperator.EQUAL, id))
                .getResult(StatusViewDto.class);
        if (list != null && !list.isEmpty()) {
            log.info(Messages.DATA_FROM_REPO_MESSAGE);
            cache.put (id, list.get(0));
            return list.get(0);
        }
        return null;
    }

    public List<StatusViewDto> getAllStatus() {
        var list = statusRepository
                .queryBuilder()
                .select(
                        Select("id"),
                        Select("name")
                )
                .getResult(StatusViewDto.class);
       if (list != null && !list.isEmpty()) return list;
       return null;
    }
}
