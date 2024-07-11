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
    private final TruckMapper truckMapper;
    
    @Override
    public ResponseEntity<String> assignTruckToGoods(String truckId, String goodsId) {
        if(truckService.assignTruckToGoods(truckId, goodsId)){
            return new ResponseEntity<>("Successfully assigned", HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<String> createTruck(Truck body) {
        TruckEntity truck = truckMapper.map(body);
        if(truckService.createTruck(truck)){
            return new ResponseEntity<>("Already exist" , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteTruck(String idd) {
        if(truckService.deleteTruck(idd)){
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Truck> getTruck(String id) {
        if(truckService.getTruck(id).isPresent()){
            Truck truck = truckMapper.map(truckService.getTruck(id).get());
            return new ResponseEntity<>(truck, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Truck>> getTrucks() {
        List<Truck> trucks = truckMapper.mapToDto(truckService.findAll());
        return new ResponseEntity<>(trucks , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Truck>> getTrucksByGoodsId(String goodsId) {
        List<Truck> trucks = truckMapper.mapToDto(truckService.findTrucksByGoodsId(goodsId));
        return new ResponseEntity<>(trucks, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Truck> updateTruck(String idt, Truck body) {
        TruckEntity truck = truckService.updateTruck(idt, truckMapper.map(body));
        if(truck == null){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(truckMapper.map(truck), HttpStatus.OK);
    }
}
