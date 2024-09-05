package com.qinshift.transportCompany.service.impl;

import com.qinshift.transportCompany.dto.ShipmentDto;
import com.qinshift.transportCompany.entity.Shipment;
import com.qinshift.transportCompany.mappers.ShipmentMapper;
import com.qinshift.transportCompany.repository.ShipmentRepository;
import com.qinshift.transportCompany.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {
    private final ShipmentRepository shipmentRepository;
    private final ShipmentMapper shipmentMapper;

    @Override
    public List<ShipmentDto> getShipments() {
        return shipmentMapper.mapToDto(shipmentRepository.findAll());
    }
	
	@Override
    public Optional<ShipmentDto> getShipmentById(Integer id) {
        return shipmentRepository.findById(id).map(shipmentMapper::map);
    }
	
    @Override
    public Optional<ShipmentDto> createShipment(ShipmentDto shipmentDto) {
        if(shipmentRepository.existsById(shipmentDto.getId())){
            return Optional.empty();
        }
        return Optional.of(shipmentMapper.map(shipmentRepository.save(shipmentMapper.map(shipmentDto))));

    }

    @Override
    public Optional<ShipmentDto> updateShipment(Integer id, ShipmentDto shipmentDto) {
        if(shipmentRepository.existsById(id)) {
            shipmentDto.setId(id);
            return Optional.ofNullable(shipmentMapper.map(shipmentRepository.save(
                shipmentMapper.map(shipmentDto))));
        }
        return Optional.empty();
    }

    @Override
    public Optional<ShipmentDto> deleteShipment(Integer id) {
        Optional<Shipment> entity = shipmentRepository.findById(id);
        if (entity.isPresent()) {
            shipmentRepository.deleteById(id);
            return Optional.of(new ShipmentDto());
        } else {
            return Optional.empty();
        }
    }
}
