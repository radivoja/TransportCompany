package com.qinshift.transportCompany.service;

import com.qinshift.transportCompany.dto.Goods;

import java.util.List;
import java.util.Optional;


public interface GoodsService {

    List<Goods> listAll();

    Optional<Goods> getGoodsById(String id);
}
