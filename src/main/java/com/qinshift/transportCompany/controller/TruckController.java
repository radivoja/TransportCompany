package com.qinshift.transportCompany.controller;

import com.qinshift.transportCompany.dto.Truck;
import com.qinshift.transportCompany.entity.TruckEntity;
import com.qinshift.transportCompany.mappers.TruckMapper;
import com.qinshift.transportCompany.service.TruckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TruckController implements TruckApi{

    private final TruckService truckService;
    
    @Override
    public ResponseEntity<String> assignTruckToGoods(String truckId, String goodsId) {
        if(truckService.assignTruckToGoods(truckId, goodsId)){
            return new ResponseEntity<>("Successfully assigned", HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<String> createTruck(Truck body) {
        if (truckService.createTruck(body).isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Already Exist");

    }

    @Override
    public ResponseEntity<String> deleteTruck(String idd) {
        if(truckService.deleteTruck(idd).isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found with "+ idd);
        }
    }

    @Override
    public ResponseEntity<Truck> getTruckById(String id) {
        return ResponseEntity.of(truckService.getTruck(id));
    }

    @Override
    public ResponseEntity<List<Truck>> getTrucks() {
        return ResponseEntity.ok(truckService.findAll());
    }

    @Override
    public ResponseEntity<List<Truck>> getTrucksByGoodsId(String goodsId) {
        return ResponseEntity.ofNullable(truckService.findTrucksByGoodsId(goodsId));

    }

    @Override
    public ResponseEntity<Truck> updateTruck(String idt, Truck body) {
        return ResponseEntity.of(truckService.updateTruck(idt, body));
    }
}
