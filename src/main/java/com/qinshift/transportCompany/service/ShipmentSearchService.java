package com.qinshift.transportCompany.service;


import com.qinshift.transportCompany.dto.ShipmentDto;

import java.util.List;

public interface ShipmentSearchService {
    List<ShipmentDto> searchShipments(String destination, Double distance, Integer truckId);
}
