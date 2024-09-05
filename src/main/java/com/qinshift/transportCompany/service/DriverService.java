package com.qinshift.transportCompany.service;


import com.qinshift.transportCompany.dto.DriverDto;

import java.util.List;
import java.util.Optional;


public interface DriverService {
    List<DriverDto> getDrivers();

    Optional<DriverDto> getDriverById(Integer id);

    Optional<DriverDto> createDriver(DriverDto driverDto);

    Optional<DriverDto> updateDriver(Integer id, DriverDto driverDto);

    Optional<DriverDto> deleteDriver(Integer id);
}
