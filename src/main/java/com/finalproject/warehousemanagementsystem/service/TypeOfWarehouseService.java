package com.finalproject.warehousemanagementsystem.service;

import com.finalproject.warehousemanagementsystem.base.TypeofWarehouse;
import com.finalproject.warehousemanagementsystem.dto.typeOfWarehouse.TypeOfWarehouseChangeStatusDto;
import com.finalproject.warehousemanagementsystem.repository.TypeOfWarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfWarehouseService {

    private final TypeOfWarehouseRepository typeOfWarehouseRepository;

    public TypeOfWarehouseService(TypeOfWarehouseRepository typeOfWarehouseRepository) {
        this.typeOfWarehouseRepository = typeOfWarehouseRepository;
    }

    public TypeofWarehouse getById(Long id) {
        return typeOfWarehouseRepository.findById(id).get();
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
