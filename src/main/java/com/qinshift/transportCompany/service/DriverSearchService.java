package com.qinshift.transportCompany.service;


import com.qinshift.transportCompany.dto.DriverDto;

import java.util.List;

public interface DriverSearchService {
    List<DriverDto> searchDrivers(String name, Integer experience, Integer companyId);
}
