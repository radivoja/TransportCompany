package com.qinshift.transportCompany.service;


import com.qinshift.transportCompany.dto.DriverDto;

import java.util.List;
import java.util.Optional;


public interface DriverService {

    Optional<DriverDto> createDriver(DriverDto driver);

    List<DriverDto> listAll();
}
