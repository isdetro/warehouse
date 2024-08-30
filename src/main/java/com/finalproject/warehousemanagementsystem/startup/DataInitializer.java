package com.finalproject.warehousemanagementsystem.startup;

import com.finalproject.warehousemanagementsystem.base.Status;
import com.finalproject.warehousemanagementsystem.base.baseEnums.Statuses;
import com.finalproject.warehousemanagementsystem.repository.StatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final StatusRepository statusRepository;

    public DataInitializer(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        setStatuses();
    }

    public void setStatuses() {
        List<Status> statuses = statusRepository.findAll();
        if (statuses.isEmpty() || statuses.size() < 2) {
            statusRepository.deleteAll();
            Arrays.stream(Statuses.values()).forEach(x -> {
                statusRepository.save(new Status(x.getId(), x.getName()));
            });
        }
    }
}
