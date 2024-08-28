package com.qinshift.transportCompany.service;

import com.qinshift.transportCompany.dto.TruckDto;

import java.util.List;
import java.util.Optional;


public interface TruckService {
    List<TruckDto> findAll();

    Optional<TruckDto> getTruck(Integer id);

    Optional<TruckDto> createTruck(TruckDto truck);

    Optional<TruckDto> updateTruck(Integer id, TruckDto truck);

    Optional<TruckDto> deleteTruck(Integer id);

   // List<Truck> findTrucksByGoodsId(Integer id);

  //  boolean assignTruckToGoods(Integer truckId, Integer goodsId);

}
