package com.qinshift.apiFirst.service;

import com.qinshift.apiFirst.entity.DriverEntity;

import java.util.List;


public interface DriverService {

    DriverEntity createDriver(DriverEntity driver);

    List<DriverEntity> listAll();
}
