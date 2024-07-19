package com.qinshift.transportCompany.service.impl;

import com.qinshift.transportCompany.dto.Goods;
import com.qinshift.transportCompany.mappers.GoodsMapper;
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
    private final GoodsMapper goodsMapper;

    @Override
    public List<Goods> listAll() {
        return goodsMapper.mapToDto(goodsRepository.findAll());
    }

    @Override
    public Optional<Goods> getGoodsById(Integer id) {
        return goodsRepository.findById(id).map(goodsMapper::map);
    }
}
