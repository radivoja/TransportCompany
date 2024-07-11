package com.qinshift.transportCompany.mappers;

import com.qinshift.transportCompany.dto.Driver;
import com.qinshift.transportCompany.entity.DriverEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TruckMapper.class})
public interface DriverMapper {
  Driver map(DriverEntity entity);
  DriverEntity map(Driver dto);

  List<Driver> listEntityToDto(List<DriverEntity> entities);
  List<DriverEntity> listDtoToEntity(List<Driver> dtos);
}
