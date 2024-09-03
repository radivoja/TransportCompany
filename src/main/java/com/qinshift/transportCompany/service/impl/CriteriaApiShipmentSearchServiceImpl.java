package com.qinshift.transportCompany.service.impl;

import com.qinshift.transportCompany.dto.ShipmentDto;
import com.qinshift.transportCompany.entity.Shipment;
import com.qinshift.transportCompany.mappers.ShipmentMapper;
import com.qinshift.transportCompany.service.ShipmentSearchService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CriteriaApiShipmentSearchServiceImpl implements ShipmentSearchService {

    private final ShipmentMapper shipmentMapper;
    private final EntityManager entityManager;

    @Override
    public List<ShipmentDto> searchShipments(String destination, Double distance, Integer truckId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Shipment> query = criteriaBuilder.createQuery(Shipment.class);
        Root<Shipment> shipment = query.from(Shipment.class);

        List<Predicate> predicates = new ArrayList<>();

        if (destination != null && !destination.isEmpty()) {
            predicates.add(criteriaBuilder.like(shipment.get("destination"), "%" + destination + "%"));
        }

        if (distance != null) {
            predicates.add(criteriaBuilder.equal(shipment.get("distance"), distance));
        }

        if (truckId != null) {
            predicates.add(criteriaBuilder.equal(shipment.get("truckId"), truckId));
        }

        query.where(predicates.toArray(new Predicate[0]));

        List<Shipment> result = entityManager.createQuery(query).getResultList();

        return shipmentMapper.mapToDto(result);

    }

}
