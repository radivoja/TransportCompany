package com.qinshift.transportCompany.service.impl;

import com.qinshift.transportCompany.dto.DriverDto;
import com.qinshift.transportCompany.entity.Driver;
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
    public List<DriverDto> getDrivers() {
        return driverMapper.mapToDto(driverRepository.findAll());
    }
	
	@Override
    public Optional<DriverDto> getDriverById(Integer id) {
        return driverRepository.findById(id).map(driverMapper::map);
    }
	
    @Override
    public Optional<DriverDto> createDriver(DriverDto driverDto) {
        if(driverRepository.existsById(driverDto.getId())){
            return Optional.empty();
        }
        return Optional.of(driverMapper.map(driverRepository.save(driverMapper.map(driverDto))));

    }

    @Override
    public Optional<DriverDto> updateDriver(Integer id, DriverDto driverDto) {
        if(driverRepository.existsById(id)) {
            driverDto.setId(id);
            return Optional.ofNullable(driverMapper.map(driverRepository.save(
                driverMapper.map(driverDto))));
        }
        return Optional.empty();
    }

    @Override
    public Optional<DriverDto> deleteDriver(Integer id) {
        Optional<Driver> entity = driverRepository.findById(id);
        if (entity.isPresent()) {
            driverRepository.deleteById(id);
            return Optional.of(new DriverDto());
        } else {
            return Optional.empty();
        }
    }
}
