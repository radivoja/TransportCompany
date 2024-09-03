package com.qinshift.transportCompany.mappers;

import com.qinshift.transportCompany.dto.ShipmentDto;
import com.qinshift.transportCompany.entity.Company;
import com.qinshift.transportCompany.entity.Shipment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShipmentMapper {
    ShipmentDto map(Company company);

    Company map(ShipmentDto company);

    List<ShipmentDto> mapToDto(List<Shipment> companies);
    List<Shipment> mapToEntity(List<ShipmentDto> companies);

}
