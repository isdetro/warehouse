package com.finalproject.warehousemanagementsystem.service;

import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.finalproject.warehousemanagementsystem.base.Status;
import com.finalproject.warehousemanagementsystem.dto.base.ModuleKeys;
import com.finalproject.warehousemanagementsystem.dto.base.RedisKeyDto;
import com.finalproject.warehousemanagementsystem.dto.status.StatusViewDto;
import com.finalproject.warehousemanagementsystem.repository.StatusRepository;
import com.finalproject.warehousemanagementsystem.util.Messages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.beyt.jdq.query.builder.QuerySimplifier.Select;

@Service
@Slf4j
public class StatusService {

    private final StatusRepository statusRepository;
    private final CacheManager cacheManager;
    private final RedisTemplate<String, Object> redisTemplate;

    public StatusService(
            StatusRepository statusRepository,
            CacheManager cacheManager,
            RedisTemplate<String, Object> redisTemplate
    ) {
        this.statusRepository = statusRepository;
        this.cacheManager = cacheManager;
        this.redisTemplate = redisTemplate;
    }

    //    public StatusViewDto getStatus(Long id) {
//        Cache cache = cacheManager.getCache (ModuleKeys.STATUS.getName());
//        StatusViewDto statusViewDto = cache.get(id, StatusViewDto.class);
//        if (statusViewDto != null) {
//            log.info(Messages.DATA_FROM_CACHE_MESSAGE);
//            return statusViewDto;
//        }
//        var list = statusRepository
//                .queryBuilder()
//                .select(
//                        Select("id"),
//                        Select("name")
//                )
//                .where(Criteria.of("id", CriteriaOperator.EQUAL, id))
//                .getResult(StatusViewDto.class);
//        if (list != null && !list.isEmpty()) {
//            log.info(Messages.DATA_FROM_REPO_MESSAGE);
//            cache.put (id, list.get(0));
//            return list.get(0);
//        }
//        return null;
//    }

    public StatusViewDto getById(Long id) {
        RedisKeyDto redisKeyDto = new RedisKeyDto();
        redisKeyDto.setId(id);
        redisKeyDto.setKey(ModuleKeys.STATUS.getName());


        StatusViewDto statusViewDto =
                (StatusViewDto) redisTemplate.opsForValue().get(redisKeyDto.toString());
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
            redisTemplate.opsForValue().set(redisKeyDto.toString(), list.get(0));
            return list.get(0);
        }
        return null;
    }

    public Status getByIdStandart(Long id) {
        return statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found!"));
    }

    public List<StatusViewDto> getAll() {
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
