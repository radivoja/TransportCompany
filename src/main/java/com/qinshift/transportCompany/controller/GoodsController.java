package com.qinshift.transportCompany.controller;

import com.qinshift.transportCompany.dto.GoodsDto;
import com.qinshift.transportCompany.service.GoodsSearchService;
import com.qinshift.transportCompany.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GoodsController implements GoodsApi{

    private final GoodsService goodsService;
    private final GoodsSearchService goodsSearchService;

    @Override
    public ResponseEntity<List<GoodsDto>> getGoods() {
        return ResponseEntity.ok(goodsService.listAll());
    }

    @Override
    public ResponseEntity<List<GoodsDto>> searchByCriteriaApi(String name, Integer quantity) {
        return ResponseEntity.ok(goodsSearchService.searchGoods(name, quantity));
    }
}
