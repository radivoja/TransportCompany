package com.qinshift.transportCompany.service;

import com.qinshift.transportCompany.dto.Truck;

import java.util.List;
import java.util.Optional;


public interface TruckService {
    List<Truck> findAll();

    Optional<Truck> getTruck(String id);

    Optional<Truck> createTruck(Truck truck);

    Optional<Truck> updateTruck(String id, Truck truck);

    Optional<Truck> deleteTruck(String id);

    List<Truck> findTrucksByGoodsId(String id);

    boolean assignTruckToGoods(String truckId, String goodsId);

}
