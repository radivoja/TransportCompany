package com.qinshift.transportCompany.controller;

import com.qinshift.transportCompany.dto.Goods;
import com.qinshift.transportCompany.mappers.GoodsMapper;
import com.qinshift.transportCompany.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GoodsController implements GoodsApi{

    private final GoodsService goodsService;
    private final GoodsMapper goodsMapper;

    @Override
    public ResponseEntity<List<Goods>> getGoods() {
        List<Goods> goods = goodsMapper.mapToDto(goodsService.findAll());
        return new ResponseEntity<>(goods , HttpStatus.OK);
    }
}
