package com.qinshift.apiFirst.service;

import com.qinshift.apiFirst.entity.GoodsEntity;

import java.util.List;
import java.util.Optional;


public interface GoodsService {

    List<GoodsEntity> findAll();

    Optional<GoodsEntity> getGoods(String id);
}
