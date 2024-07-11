package com.qinshift.transportCompany.service;

import com.qinshift.transportCompany.entity.GoodsEntity;

import java.util.List;
import java.util.Optional;


public interface GoodsService {

    List<GoodsEntity> findAll();

    Optional<GoodsEntity> getGoods(String id);
}
