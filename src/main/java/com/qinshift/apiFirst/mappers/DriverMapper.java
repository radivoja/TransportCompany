package com.qinshift.apiFirst.mappers;

import com.qinshift.apiFirst.dto.Driver;
import com.qinshift.apiFirst.entity.DriverEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TruckMapper.class})
public interface DriverMapper {
  Driver map(DriverEntity entity);
  DriverEntity map(Driver dto);

  List<Driver> listEntityToDto(List<DriverEntity> entities);
  List<DriverEntity> listDtoToEntity(List<Driver> dtos);
}
