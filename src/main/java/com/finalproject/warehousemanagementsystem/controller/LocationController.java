package com.finalproject.warehousemanagementsystem.controller;

import com.finalproject.warehousemanagementsystem.dto.location.LocationIUDRequest;
import com.finalproject.warehousemanagementsystem.dto.location.LocationJdqViewDto;
import com.finalproject.warehousemanagementsystem.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<LocationJdqViewDto>> getAllLocations() {
        return ResponseEntity.ok(locationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationJdqViewDto> getLocationById(@PathVariable Long id) {
        return ResponseEntity.ok(locationService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Object> addLocation(@RequestBody List<LocationIUDRequest> locationIUDRequests) {
        locationService.saveIUDRequest(locationIUDRequests);
        return ResponseEntity.ok().build();
    }
}
