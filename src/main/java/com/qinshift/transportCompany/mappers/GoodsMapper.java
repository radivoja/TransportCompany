package com.qinshift.transportCompany.mappers;

import com.qinshift.transportCompany.dto.GoodsDto;
import com.qinshift.transportCompany.entity.Goods;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface GoodsMapper {
    @Mapping(target = "shipments", source = "shipments", ignore = true) // circular dependencies
    GoodsDto map(Goods goods);

    @Mapping(target = "shipments", source = "shipments", ignore = true) // circular dependencies
    Goods map(GoodsDto goodsDto);

    @Mapping(target = "shipments", source = "shipments", ignore = true)
    List<GoodsDto> mapToDto(List<Goods> goods);

    @Mapping(target = "shipments", source = "shipments", ignore = true) // circular dependencies
    List<Goods> mapToEntity(List<GoodsDto> goodsDto);
}
