package com.qinshift.transportCompany.controller;

import com.qinshift.transportCompany.dto.FuelType;
import com.qinshift.transportCompany.dto.TruckDto;
import com.qinshift.transportCompany.service.TruckSearchService;
import com.qinshift.transportCompany.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TruckController implements TruckApi{

    @Autowired
    private TruckService truckService;

    @Autowired
    @Qualifier("criteriaApi")
    private TruckSearchService criteriaApi;

    @Autowired
    @Qualifier("queryDsl")
    private TruckSearchService queryDsl;

    @Override
    public ResponseEntity<String> createTruck(TruckDto body) {
        if (truckService.createTruck(body).isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Already Exist");
    }

    @Override
    public ResponseEntity<String> deleteTruck(Integer idd) {
        if(truckService.deleteTruck(idd).isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found with "+ idd);
        }
    }

    @Override
    public ResponseEntity<TruckDto> getTruckById(Integer id) {
        return ResponseEntity.of(truckService.getTruckById(id));
    }

    @Override
    public ResponseEntity<List<TruckDto>> getTrucks() {
        return ResponseEntity.ok(truckService.getTrucks());
    }

    @Override
    public ResponseEntity<List<TruckDto>> searchTrucksByCriteriaApi(Integer vehicleWeight, String model, String manufacturer, Integer yearManufactured, Integer horsePower, Integer torque, Double cargoCapacity, Boolean aerodynamics, FuelType fuelType) {
        return ResponseEntity.ok(criteriaApi.searchTrucks(
                vehicleWeight,
                model,
                manufacturer,
                horsePower,
                yearManufactured,
                torque,
                cargoCapacity,
                aerodynamics,
                fuelType));
    }

    @Override
    public ResponseEntity<List<TruckDto>> searchTrucksByQueryDsl(Integer vehicleWeight, String model, String manufacturer, Integer yearManufactured, Integer horsePower, Integer torque, Double cargoCapacity, Boolean aerodynamics, FuelType fuelType) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<TruckDto> updateTruck(Integer idt, TruckDto body) {
        return ResponseEntity.of(truckService.updateTruck(idt, body));
    }
}
