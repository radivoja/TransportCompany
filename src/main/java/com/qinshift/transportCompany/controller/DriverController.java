package com.qinshift.transportCompany.controller;

import com.qinshift.transportCompany.dto.Driver;
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

    @Override
    public ResponseEntity<String> createDriver(Driver body) {
        if (driverService.createDriver(body).isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Already Exist");
    }

    @Override
    public ResponseEntity<List<Driver>> getDrivers() {
        return ResponseEntity.ok(driverService.listAll());
    }
}
