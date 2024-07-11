package com.qinshift.apiFirst.service.impl;

import com.qinshift.apiFirst.entity.DriverEntity;
import com.qinshift.apiFirst.repository.DriverRepository;
import com.qinshift.apiFirst.service.DriverService;
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
