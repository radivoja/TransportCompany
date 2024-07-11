package com.qinshift.apiFirst.service.impl;

import com.qinshift.apiFirst.entity.GoodsEntity;
import com.qinshift.apiFirst.repository.GoodsRepository;
import com.qinshift.apiFirst.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService {
    private final GoodsRepository goodsRepository;

    @Override
    public List<GoodsEntity> findAll() {
        return goodsRepository.findAll();
    }

    @Override
    public Optional<GoodsEntity> getGoods(String id) {
        return goodsRepository.findById(id);
    }
}
