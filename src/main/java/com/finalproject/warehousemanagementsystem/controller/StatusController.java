package com.finalproject.warehousemanagementsystem.controller;

import com.finalproject.warehousemanagementsystem.base.Status;
import com.finalproject.warehousemanagementsystem.service.StatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/statuses")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public List<Status> getStatus(){
        return statusService.getAllStatus();
    }

    @GetMapping("/{id}")
    public Status getStatus(@PathVariable Long id){
        return statusService.getStatus(id);
    }
}
