package com.qinshift.transportCompany.service;

import com.qinshift.transportCompany.dto.GoodsDto;

import java.util.List;
import java.util.Optional;


public interface GoodsService {

    List<GoodsDto> listAll();

    Optional<GoodsDto> getGoodsById(Integer id);
}
