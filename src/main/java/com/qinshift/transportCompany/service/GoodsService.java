package com.qinshift.transportCompany.service;
import com.qinshift.transportCompany.dto.GoodsDto;

import java.util.List;
import java.util.Optional;

public interface GoodsService {
    List<GoodsDto> getGoods();

    Optional<GoodsDto> getGoodsById(Integer id);

    Optional<GoodsDto> createGoods(GoodsDto goodsDto);

    Optional<GoodsDto> updateGoods(Integer id, GoodsDto goodsDto);

    Optional<GoodsDto> deleteGoods(Integer id);
}
