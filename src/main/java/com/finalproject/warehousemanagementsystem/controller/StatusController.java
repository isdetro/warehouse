package com.finalproject.warehousemanagementsystem.controller;

import com.finalproject.warehousemanagementsystem.base.Status;
import com.finalproject.warehousemanagementsystem.dto.status.StatusViewDto;
import com.finalproject.warehousemanagementsystem.service.StatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<StatusViewDto>> getStatus(){
       List<StatusViewDto> list = statusService.getAllStatus();
       if(list == null || list.isEmpty()){ return new ResponseEntity<>(HttpStatus.NO_CONTENT); }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusViewDto> getStatus(@PathVariable Long id){
        StatusViewDto statusViewDto = statusService.getStatus2(id);
        if(statusViewDto == null){ return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
        return new ResponseEntity<>(statusViewDto, HttpStatus.OK);
    }
}
