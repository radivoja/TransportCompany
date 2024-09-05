package com.qinshift.transportCompany.mappers;


import com.qinshift.transportCompany.dto.ShipmentDto;
import com.qinshift.transportCompany.entity.Shipment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShipmentMapper {
    ShipmentDto map(Shipment shipment);

    Shipment map(ShipmentDto shipmentDto);

    List<ShipmentDto> mapToDto(List<Shipment> shipments);
    List<Shipment> mapToEntity(List<ShipmentDto> shipmentsDto);

}
