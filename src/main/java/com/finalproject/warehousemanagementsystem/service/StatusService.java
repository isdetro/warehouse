package com.finalproject.warehousemanagementsystem.service;

import com.beyt.jdq.dto.Criteria;
import com.beyt.jdq.dto.enums.CriteriaOperator;
import com.finalproject.warehousemanagementsystem.dto.status.StatusViewDto;
import com.finalproject.warehousemanagementsystem.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.beyt.jdq.query.builder.QuerySimplifier.Select;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public StatusViewDto getStatus(Long id) {
        var list = statusRepository
                .queryBuilder()
                .select(
                        Select("id"),
                        Select("name")
                )
                .where(Criteria.of("id", CriteriaOperator.EQUAL, id))
                .getResult(StatusViewDto.class);
        if (list != null && !list.isEmpty()) {
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
