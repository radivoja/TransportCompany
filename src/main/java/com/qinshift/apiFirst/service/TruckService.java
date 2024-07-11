package com.qinshift.apiFirst.service;

import com.qinshift.apiFirst.entity.TruckEntity;

import java.util.List;
import java.util.Optional;


public interface TruckService {
    List<TruckEntity> findAll();

    Optional<TruckEntity> getTruck(String id);

    boolean createTruck(TruckEntity truck);

    TruckEntity updateTruck(String id, TruckEntity truck);

    boolean deleteTruck(String id);

    List<TruckEntity> findTrucksByGoodsId(String id);

    boolean assignTruckToGoods(String truckId, String goodsId);

}
