package com.qinshift.transportCompany.service;


import com.qinshift.transportCompany.dto.FuelType;
import com.qinshift.transportCompany.dto.TruckDto;

import java.util.List;

public interface TruckSearchService {
    List<TruckDto> searchTrucks(Integer vehicleWeight, String model, String manufacturer, Integer horsePower, Integer yearManufactured,
                                       Integer torque, Double cargoCapacity, Boolean aerodynamics, FuelType fuelType);
}
