package com.qinshift.transportCompany.mappers;

import com.qinshift.transportCompany.dto.TruckDto;
import com.qinshift.transportCompany.entity.Truck;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TruckMapper {
    TruckDto map(Truck entity);

    Truck map(TruckDto dto);

    @Mapping(target = "shipments", source = "shipments", ignore = true) // circular dependencies
    List<TruckDto> mapToDto(List<Truck> trucks);

    @Mapping(target = "shipments", source = "shipments", ignore = true) // circular dependencies
    List<Truck> mapToEntity(List<TruckDto> truckDto);
}
