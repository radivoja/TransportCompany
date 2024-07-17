package com.qinshift.transportCompany.service;

import com.qinshift.transportCompany.dto.Driver;

import java.util.List;
import java.util.Optional;


public interface DriverService {

    Optional<Driver> createDriver(Driver driver);

    List<Driver> listAll();
}
