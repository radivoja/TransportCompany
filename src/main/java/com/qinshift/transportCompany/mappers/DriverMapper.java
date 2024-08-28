package com.qinshift.transportCompany.mappers;

import com.qinshift.transportCompany.dto.DriverDto;
import com.qinshift.transportCompany.entity.Driver;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TruckMapper.class})
public interface DriverMapper {
  DriverDto map(Driver entity);
  Driver map(DriverDto dto);

  List<DriverDto> mapToDto(List<Driver> entities);
  List<Driver> mapToEntity(List<DriverDto> dtos);
}
