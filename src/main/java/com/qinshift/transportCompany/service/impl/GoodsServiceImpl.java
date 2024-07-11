package com.qinshift.transportCompany.service.impl;

import com.qinshift.transportCompany.entity.GoodsEntity;
import com.qinshift.transportCompany.repository.GoodsRepository;
import com.qinshift.transportCompany.service.GoodsService;
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
