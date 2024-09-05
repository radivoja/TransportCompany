package com.qinshift.transportCompany.service.impl;

import com.qinshift.transportCompany.dto.GoodsDto;
import com.qinshift.transportCompany.entity.Goods;
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
    public List<GoodsDto> getGoods() {
        return goodsMapper.mapToDto(goodsRepository.findAll());
    }
	
	@Override
    public Optional<GoodsDto> getGoodsById(Integer id) {
        return goodsRepository.findById(id).map(goodsMapper::map);
    }
	
    @Override
    public Optional<GoodsDto> createGoods(GoodsDto goodsDto) {
        if(goodsRepository.existsById(goodsDto.getId())){
            return Optional.empty();
        }
        return Optional.of(goodsMapper.map(goodsRepository.save(goodsMapper.map(goodsDto))));

    }

    @Override
    public Optional<GoodsDto> updateGoods(Integer id, GoodsDto goodsDto) {
        if(goodsRepository.existsById(id)) {
            goodsDto.setId(id);
            return Optional.ofNullable(goodsMapper.map(goodsRepository.save(
                goodsMapper.map(goodsDto))));
        }
        return Optional.empty();
    }

    @Override
    public Optional<GoodsDto> deleteGoods(Integer id) {
        Optional<Goods> entity = goodsRepository.findById(id);
        if (entity.isPresent()) {
            goodsRepository.deleteById(id);
            return Optional.of(new GoodsDto());
        } else {
            return Optional.empty();
        }
    }
}
