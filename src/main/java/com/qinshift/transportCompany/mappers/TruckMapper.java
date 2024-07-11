package com.qinshift.transportCompany.mappers;

import com.qinshift.transportCompany.dto.Truck;
import com.qinshift.transportCompany.entity.TruckEntity;
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
