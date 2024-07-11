package com.qinshift.transportCompany.service;

import com.qinshift.transportCompany.entity.DriverEntity;

import java.util.List;


public interface DriverService {

    DriverEntity createDriver(DriverEntity driver);

    List<DriverEntity> listAll();
}
