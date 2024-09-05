package com.qinshift.transportCompany.controller;


import com.qinshift.transportCompany.dto.ShipmentDto;
import com.qinshift.transportCompany.service.ShipmentSearchService;
import com.qinshift.transportCompany.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ShipmentController implements ShipmentApi {
    private final ShipmentService shipmentService;
    private final ShipmentSearchService shipmentSearchService;

    @Override
    public ResponseEntity<List<ShipmentDto>> getShipments() {
        return ResponseEntity.ok(shipmentService.getShipments());
    }

    @Override
    public ResponseEntity<ShipmentDto> getShipmentById(Integer id) {
        return ResponseEntity.of(shipmentService.getShipmentById(id));
    }

    @Override
    public ResponseEntity<String> createShipment(ShipmentDto body) {
        if (shipmentService.createShipment(body).isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Already Exist");

    }

    @Override
    public ResponseEntity<ShipmentDto> updateShipment(Integer idp, ShipmentDto body) {
        return ResponseEntity.of(shipmentService.updateShipment(idp, body));
    }

    @Override
    public ResponseEntity<String> deleteShipmentById(Integer idd) {
        if(shipmentService.deleteShipment(idd).isPresent()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found with "+ idd);
        }
    }

    @Override
    public ResponseEntity<List<ShipmentDto>> searchByCriteriaApi(String destination, Double distance, Integer truckId) {
        return ResponseEntity.ok(shipmentSearchService.searchShipments(destination, distance, truckId));
    }

}
