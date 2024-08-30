package com.finalproject.warehousemanagementsystem.startup;

import com.finalproject.warehousemanagementsystem.base.Status;
import com.finalproject.warehousemanagementsystem.base.TypeofWarehouse;
import com.finalproject.warehousemanagementsystem.base.baseEnums.Statuses;
import com.finalproject.warehousemanagementsystem.base.baseEnums.TypeOfWarehouses;
import com.finalproject.warehousemanagementsystem.repository.StatusRepository;
import com.finalproject.warehousemanagementsystem.repository.TypeOfWarehouseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final StatusRepository statusRepository;
    private final TypeOfWarehouseRepository typeOfWarehouseRepository;

    public DataInitializer(StatusRepository statusRepository, TypeOfWarehouseRepository typeOfWarehouseRepository) {
        this.statusRepository = statusRepository;
        this.typeOfWarehouseRepository = typeOfWarehouseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        setStatuses();
        setTypesOfWarehouses();
    }

    private void setStatuses() {
        List<Status> statuses = statusRepository.findAll();
        if (statuses.isEmpty() || statuses.size() < 2) {
            statusRepository.deleteAll();
            Arrays.stream(Statuses.values()).forEach(x -> {
                statusRepository.save(new Status(x.getId(), x.getName()));
            });
        }
    }

    private void setTypesOfWarehouses() {
        List<TypeofWarehouse> typeofWarehouses = typeOfWarehouseRepository.findAll();
        if (typeofWarehouses.isEmpty() || typeofWarehouses.size() < 3) {
            typeOfWarehouseRepository.deleteAll();
            Arrays.stream(TypeOfWarehouses.values()).forEach(x -> {
                typeOfWarehouseRepository.save(new TypeofWarehouse(x.getId(),x.getName(), Statuses.ACTIVE.getId()));
            });
        }
    }


}
