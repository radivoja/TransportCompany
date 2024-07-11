package com.qinshift.apiFirst.mappers;

import com.qinshift.apiFirst.dto.Truck;
import com.qinshift.apiFirst.entity.TruckEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TruckMapper {
    @Mapping(target = "goods", source = "goods", ignore = true) // circular dependencies
    Truck map(TruckEntity entity);
    @Mapping(target = "goods", source = "goods", ignore = true) // circular dependencies

    TruckEntity map(Truck dto);

    @Mapping(target = "goods", source = "goods", ignore = true) // circular dependencies
    List<Truck> mapToDto(List<TruckEntity> entities);

    @Mapping(target = "goods", source = "goods", ignore = true) // circular dependencies
    List<TruckEntity> mapToEntity(List<Truck> dtos);
}
