package com.qinshift.transportCompany.controller;

import com.qinshift.transportCompany.dto.Driver;
import com.qinshift.transportCompany.entity.DriverEntity;
import com.qinshift.transportCompany.mappers.DriverMapper;
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
    private final DriverMapper driverMapper;

    @Override
    public ResponseEntity<String> createDriver(Driver body) {
        DriverEntity driver = driverMapper.map(body);
        if(driverService.createDriver(driver) != null){
            return new ResponseEntity<>(driver.toString() , HttpStatus.OK);
        }
        return new ResponseEntity<>("Already exist" , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Driver>> getDrivers() {
        List<Driver> drivers = driverMapper.listEntityToDto(driverService.listAll());
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }
}
