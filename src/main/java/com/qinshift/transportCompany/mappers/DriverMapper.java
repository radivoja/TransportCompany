package com.qinshift.transportCompany.mappers;

import com.qinshift.transportCompany.dto.DriverDto;
import com.qinshift.transportCompany.entity.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TruckMapper.class})
public interface DriverMapper {
  @Mapping(target = "company", source = "company", ignore = true) // circular dependencies
  DriverDto map(Driver entity);

  @Mapping(target = "company", source = "company", ignore = true) // circular dependencies
  Driver map(DriverDto dto);

  List<DriverDto> mapToDto(List<Driver> entities);
  List<Driver> mapToEntity(List<DriverDto> dtos);
}
