package com.finalproject.warehousemanagementsystem.service;

import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.CriteriaList;
import com.beyt.jdq.dto.DynamicQuery;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.finalproject.warehousemanagementsystem.dto.location.LocationIUDRequest;
import com.finalproject.warehousemanagementsystem.dto.location.LocationJdqViewDto;
import com.finalproject.warehousemanagementsystem.mapper.LocationMapper;
import com.finalproject.warehousemanagementsystem.model.Location;
import com.finalproject.warehousemanagementsystem.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationService(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
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
        DynamicQuery dynamicQuery = new DynamicQuery();
        dynamicQuery.setWhere(CriteriaList.of(Criteria.of("id", CriteriaOperator.EQUAL, id)));
        List<LocationJdqViewDto> list = locationRepository.findAll(dynamicQuery, LocationJdqViewDto.class);
        if (list != null && !list.isEmpty()) {
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
                    save(locationMapper.fromIUDRequestToDbo(iudRequest));
            }
        }
    }


}
