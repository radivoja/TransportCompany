package com.qinshift.transportCompany.mappers;

import com.qinshift.transportCompany.dto.DriverDto;
import com.qinshift.transportCompany.entity.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TruckMapper.class})
public interface DriverMapper {
  @Mapping(target = "company", source = "company", ignore = true) // circular dependencies
  DriverDto map(Driver driver);

  @Mapping(target = "company", source = "company", ignore = true) // circular dependencies
  Driver map(DriverDto driverDto);

  List<DriverDto> mapToDto(List<Driver> drivers);

  List<Driver> mapToEntity(List<DriverDto> driversDto);
}
