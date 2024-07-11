package com.qinshift.transportCompany.service.impl;

import com.qinshift.transportCompany.entity.DriverEntity;
import com.qinshift.transportCompany.repository.DriverRepository;
import com.qinshift.transportCompany.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;

    @Override
    public DriverEntity createDriver(DriverEntity driverEntity) {
        if(!driverRepository.existsById(driverEntity.getId())){
            driverRepository.save(driverEntity);
            return driverEntity;
        } else{
            return null;
        }
    }

    @Override
    public List<DriverEntity> listAll() {
        return driverRepository.findAll();
    }
}
