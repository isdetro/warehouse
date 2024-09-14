package com.finalproject.warehousemanagementsystem.service;

import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.CriteriaList;
import com.beyt.jdq.dto.DynamicQuery;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.finalproject.warehousemanagementsystem.dto.base.RedisKeyDto;
import com.finalproject.warehousemanagementsystem.dto.location.LocationIUDRequest;
import com.finalproject.warehousemanagementsystem.dto.location.LocationJdqViewDto;
import com.finalproject.warehousemanagementsystem.mapper.LocationMapper;
import com.finalproject.warehousemanagementsystem.model.Location;
import com.finalproject.warehousemanagementsystem.repository.LocationRepository;
import com.finalproject.warehousemanagementsystem.util.Messages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;
    private final RedisTemplate<String, Object> redisTemplate;

    public LocationService(
            LocationRepository locationRepository,
            LocationMapper locationMapper,
            RedisTemplate<String, Object> redisTemplate
    ) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
        this.redisTemplate = redisTemplate;
    }

    public List<LocationJdqViewDto> getAll() {
        DynamicQuery dynamicQuery = new DynamicQuery();
        List<LocationJdqViewDto> list = locationRepository.findAll(dynamicQuery, LocationJdqViewDto.class);
        if (list != null && !list.isEmpty()) {
            return list;
        }
        return new ArrayList<>();
    }

    public LocationJdqViewDto getById(Long id) {
        RedisKeyDto redisKeyDto = new RedisKeyDto();
        redisKeyDto.setKey("location");
        redisKeyDto.setId(id);

        LocationJdqViewDto locationJdqViewDto =
                (LocationJdqViewDto) redisTemplate.opsForValue().get(redisKeyDto.toString());

        if (locationJdqViewDto != null) {
            log.info(Messages.DATA_FROM_CACHE_MESSAGE);
            return locationJdqViewDto;
        }


        DynamicQuery dynamicQuery = new DynamicQuery();
        dynamicQuery.setWhere(CriteriaList.of(Criteria.of("id", CriteriaOperator.EQUAL, id)));
        List<LocationJdqViewDto> list = locationRepository.findAll(dynamicQuery, LocationJdqViewDto.class);
        if (list != null && !list.isEmpty()) {
            log.info(Messages.DATA_FROM_REPO_MESSAGE);
            redisTemplate.opsForValue().set(redisKeyDto.toString(), list.get(0));
            return list.get(0);
        }
        return null;
    }


    public Long save(Location location) {
        return locationRepository.save(location).getId();
    }

    public void saveIUDRequest(List<LocationIUDRequest> locationIUDRequest) {
        if (locationIUDRequest != null && !locationIUDRequest.isEmpty()) {
            for (LocationIUDRequest iudRequest : locationIUDRequest) {
                Long id = save(locationMapper.fromIUDRequestToDbo(iudRequest));

                RedisKeyDto redisKeyDto = new RedisKeyDto();
                redisKeyDto.setKey("location");
                redisKeyDto.setId(id);

                LocationJdqViewDto locationJdqViewDto =
                        (LocationJdqViewDto) redisTemplate.opsForValue().get(redisKeyDto.toString());
                if (locationJdqViewDto != null) {
                    log.info(Messages.UPDATE_CACHE_DATA_MESSAGE);
                    redisTemplate.delete(redisKeyDto.toString());
                }

                LocationJdqViewDto locationJdqViewDtoNew = getById(id);
                redisTemplate.opsForValue().set(redisKeyDto.toString(), locationJdqViewDtoNew);
            }
        }
    }


}
