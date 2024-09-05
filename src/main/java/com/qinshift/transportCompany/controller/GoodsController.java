package com.qinshift.transportCompany.controller;


import com.qinshift.transportCompany.dto.GoodsDto;
import com.qinshift.transportCompany.service.GoodsSearchService;
import com.qinshift.transportCompany.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GoodsController implements GoodsApi {
    private final GoodsService goodsService;
    private final GoodsSearchService goodsSearchService;

    @Override
    public ResponseEntity<List<GoodsDto>> getGoods() {
        return ResponseEntity.ok(goodsService.getGoods());
    }

    @Override
    public ResponseEntity<GoodsDto> getGoodsById(Integer id) {
        return ResponseEntity.of(goodsService.getGoodsById(id));
    }

    @Override
    public ResponseEntity<String> createGoods(GoodsDto body) {
        if (goodsService.createGoods(body).isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Already Exist");
    }

    @Override
    public ResponseEntity<GoodsDto> updateGoods(Integer idp, GoodsDto body) {
        return ResponseEntity.of(goodsService.updateGoods(idp, body));
    }

    @Override
    public ResponseEntity<String> deleteGoodsById(Integer idd) {
        if(goodsService.deleteGoods(idd).isPresent()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found with "+ idd);
        }
    }

    @Override
    public ResponseEntity<List<GoodsDto>> searchGoodsByCriteriaApi(String name, Integer quantity) {
        return ResponseEntity.ok(goodsSearchService.searchGoods(name, quantity));
    }
}
