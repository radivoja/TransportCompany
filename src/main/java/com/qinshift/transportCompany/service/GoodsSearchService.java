package com.qinshift.transportCompany.service;


import com.qinshift.transportCompany.dto.GoodsDto;

import java.util.List;

public interface GoodsSearchService {
    List<GoodsDto> searchGoods(String name, Integer quantity);
}
