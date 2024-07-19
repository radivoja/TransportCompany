package com.qinshift.transportCompany.service;

import com.qinshift.transportCompany.dto.Truck;

import java.util.List;
import java.util.Optional;


public interface TruckService {
    List<Truck> findAll();

    Optional<Truck> getTruck(Integer id);

    Optional<Truck> createTruck(Truck truck);

    Optional<Truck> updateTruck(Integer id, Truck truck);

    Optional<Truck> deleteTruck(Integer id);

    List<Truck> findTrucksByGoodsId(Integer id);

    boolean assignTruckToGoods(Integer truckId, Integer goodsId);

}
