package com.qinshift.apiFirst.mappers;

import com.qinshift.apiFirst.dto.Goods;
import com.qinshift.apiFirst.entity.GoodsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface GoodsMapper {
    @Mapping(target = "trucks", source = "trucks", ignore = true) // circular dependencies
    Goods map(GoodsEntity entity);
    @Mapping(target = "trucks", source = "trucks", ignore = true) // circular dependencies
    GoodsEntity map(Goods dto);


    @Mapping(target = "trucks", source = "trucks", ignore = true)
    List<Goods> mapToDto(List<GoodsEntity> entities);
    @Mapping(target = "trucks", source = "trucks", ignore = true) // circular dependencies
    List<GoodsEntity> mapToEntity(List<Goods> dtos);
}
