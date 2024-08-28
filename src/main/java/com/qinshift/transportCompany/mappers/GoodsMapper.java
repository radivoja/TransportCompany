package com.qinshift.transportCompany.mappers;

import com.qinshift.transportCompany.dto.GoodsDto;
import com.qinshift.transportCompany.entity.Goods;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface GoodsMapper {
    @Mapping(target = "shipments", source = "shipments", ignore = true) // circular dependencies
    GoodsDto map(Goods entity);
    @Mapping(target = "shipments", source = "shipments", ignore = true) // circular dependencies
    Goods map(GoodsDto dto);


    @Mapping(target = "shipments", source = "shipments", ignore = true)
    List<GoodsDto> mapToDto(List<Goods> entities);
    @Mapping(target = "shipments", source = "shipments", ignore = true) // circular dependencies
    List<Goods> mapToEntity(List<GoodsDto> dtos);
}
