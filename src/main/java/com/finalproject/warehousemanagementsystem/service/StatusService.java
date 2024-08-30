package com.finalproject.warehousemanagementsystem.service;

import com.finalproject.warehousemanagementsystem.base.Status;
import com.finalproject.warehousemanagementsystem.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Status getStatus(Long id) {
        return statusRepository.findById(id).get();
    }

    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }
}
