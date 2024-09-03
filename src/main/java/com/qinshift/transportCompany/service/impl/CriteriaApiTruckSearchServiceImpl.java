package com.qinshift.transportCompany.service.impl;

import com.qinshift.transportCompany.dto.FuelType;
import com.qinshift.transportCompany.dto.TruckDto;
import com.qinshift.transportCompany.entity.Truck;
import com.qinshift.transportCompany.mappers.TruckMapper;
import com.qinshift.transportCompany.service.TruckSearchService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("criteriaApi")
@RequiredArgsConstructor
public class CriteriaApiTruckSearchServiceImpl implements TruckSearchService {

    private final TruckMapper truckMapper;
    private final EntityManager entityManager;

    @Override
    public List<TruckDto> searchTrucks(Integer vehicleWeight, String model, String manufacturer, Integer horsePower, Integer yearManufactured,
                                       Integer torque, Double cargoCapacity, Boolean aerodynamics, FuelType fuelType) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Truck> query = criteriaBuilder.createQuery(Truck.class);
        Root<Truck> truck = query.from(Truck.class);

        List<Predicate> predicates = new ArrayList<>();

        if (vehicleWeight != null) {
            predicates.add(criteriaBuilder.equal(truck.get("vehicleWeight"), vehicleWeight));
        }

        if (model != null && !model.isEmpty()) {
            predicates.add(criteriaBuilder.like(truck.get("model"), "%" + model + "%"));
        }

        if (manufacturer != null && !manufacturer.isEmpty()) {
            predicates.add(criteriaBuilder.like(truck.get("manufacturer"), "%" + manufacturer + "%"));
        }

        if (horsePower != null) {
            predicates.add(criteriaBuilder.equal(truck.get("horsePower"), horsePower));
        }

        if (yearManufactured != null) {
            predicates.add(criteriaBuilder.equal(truck.get("yearManufactured"), yearManufactured));
        }

        if (torque != null) {
            predicates.add(criteriaBuilder.equal(truck.get("torque"), torque));
        }

        if (cargoCapacity != null) {
            predicates.add(criteriaBuilder.equal(truck.get("cargoCapacity"), cargoCapacity));
        }

        if (aerodynamics != null) {
            predicates.add(criteriaBuilder.equal(truck.get("aerodynamics"), aerodynamics));
        }

        if (fuelType != null) {
            predicates.add(criteriaBuilder.equal(truck.get("fuelType"), fuelType));
        }

        query.where(predicates.toArray(new Predicate[0]));

        List<Truck> result = entityManager.createQuery(query).getResultList();

        return truckMapper.mapToDto(result);

    }

}
