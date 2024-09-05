package com.qinshift.transportCompany.service;
import com.qinshift.transportCompany.dto.ShipmentDto;

import java.util.List;
import java.util.Optional;

public interface ShipmentService {
    List<ShipmentDto> getShipments();

    Optional<ShipmentDto> getShipmentById(Integer id);

    Optional<ShipmentDto> createShipment(ShipmentDto shipmentDto);

    Optional<ShipmentDto> updateShipment(Integer id, ShipmentDto shipmentDto);

    Optional<ShipmentDto> deleteShipment(Integer id);
}
