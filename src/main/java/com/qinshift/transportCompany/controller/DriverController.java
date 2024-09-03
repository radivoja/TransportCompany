package com.qinshift.transportCompany.controller;

import com.qinshift.transportCompany.dto.DriverDto;
import com.qinshift.transportCompany.service.DriverSearchService;
import com.qinshift.transportCompany.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DriverController implements DriverApi{

    private final DriverService driverService;
    private final DriverSearchService driverSearchService;

    @Override
    public ResponseEntity<String> createDriver(DriverDto body) {
        if (driverService.createDriver(body).isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Already Exist");
    }

    @Override
    public ResponseEntity<List<DriverDto>> getDrivers() {
        return ResponseEntity.ok(driverService.listAll());
    }

    @Override
    public ResponseEntity<List<DriverDto>> searchByCriteriaApi(String name, Integer experience, Integer companyId) {
        return ResponseEntity.ok(driverSearchService.searchDrivers(name, experience, companyId));
    }
}
