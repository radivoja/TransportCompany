package com.qinshift.transportCompany.controller;

import com.qinshift.transportCompany.dto.ShipmentDto;
import com.qinshift.transportCompany.service.ShipmentSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
public class ShipmentController implements ShipmentApi{
    private final ShipmentSearchService shipmentSearchService;

    @Override
    public ResponseEntity<List<ShipmentDto>> searchByCriteriaApi(String destination, Double distance, Integer truckId) {
        return ResponseEntity.ok(shipmentSearchService.searchShipments(destination,distance,truckId));
    }
}
