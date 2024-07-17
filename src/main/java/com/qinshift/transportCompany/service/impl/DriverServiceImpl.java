package com.qinshift.transportCompany.service.impl;

import com.qinshift.transportCompany.dto.Driver;
import com.qinshift.transportCompany.mappers.DriverMapper;
import com.qinshift.transportCompany.repository.DriverRepository;
import com.qinshift.transportCompany.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    @Override
    public Optional<Driver> createDriver(Driver driver) {
        if(driverRepository.existsById(driver.getId())){
            return Optional.empty();
        }
        return Optional.of(driverMapper.map(driverRepository.save(driverMapper.map(driver))));

    }

    @Override
    public List<Driver> listAll() {
        return driverMapper.mapToDto(driverRepository.findAll());
    }
}
