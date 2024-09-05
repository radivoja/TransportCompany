package com.qinshift.transportCompany.service.impl;

import com.qinshift.transportCompany.dto.TruckDto;
import com.qinshift.transportCompany.entity.Truck;
import com.qinshift.transportCompany.mappers.TruckMapper;
import com.qinshift.transportCompany.repository.GoodsRepository;
import com.qinshift.transportCompany.repository.TruckRepository;
import com.qinshift.transportCompany.service.TruckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TruckServiceImpl implements TruckService {

    private final TruckRepository truckRepository;
    private final GoodsRepository goodsRepository;
    private final TruckMapper truckMapper;

    @Override
    public List<TruckDto> getTrucks() {
        return truckMapper.mapToDto(truckRepository.findAll());
    }

    @Override
    public Optional<TruckDto> getTruckById(Integer id) {
        return truckRepository.findById(id).map(truckMapper::map);
    }

    @Override
    public Optional<TruckDto> createTruck(TruckDto truck) {
        if(truckRepository.existsById(truck.getId())){
            return Optional.empty();
        }
        return Optional.of(truckMapper.map(truckRepository.save(truckMapper.map(truck))));

    }

    @Override
    public Optional<TruckDto> updateTruck(Integer id, TruckDto truck) {
        if(truckRepository.existsById(id)) {
            truck.setId(id);
            return Optional.ofNullable(truckMapper.map(truckRepository.save(
                    truckMapper.map(truck))));
        }
        return Optional.empty();
    }

    @Override
    public Optional<TruckDto> deleteTruck(Integer id) {
        Optional<Truck> entity = truckRepository.findById(id);
        if (entity.isPresent()) {
            truckRepository.deleteById(id);
            return Optional.of(new TruckDto());
        } else {
            return Optional.empty();
        }
    }
}
