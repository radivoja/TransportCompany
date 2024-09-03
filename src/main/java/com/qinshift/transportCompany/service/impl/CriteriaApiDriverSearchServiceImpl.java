package com.qinshift.transportCompany.service.impl;

import com.qinshift.transportCompany.dto.DriverDto;
import com.qinshift.transportCompany.entity.Driver;
import com.qinshift.transportCompany.mappers.DriverMapper;
import com.qinshift.transportCompany.service.DriverSearchService;
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
public class CriteriaApiDriverSearchServiceImpl implements DriverSearchService {

    private final DriverMapper driverMapper;
    private final EntityManager entityManager;


    @Override
    public List<DriverDto> searchDrivers(String name, Integer experience, Integer companyId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Driver> query = criteriaBuilder.createQuery(Driver.class);
        Root<Driver> driver = query.from(Driver.class);

        List<Predicate> predicates = new ArrayList<>();


        if (name != null && !name.isEmpty()) {
            predicates.add(criteriaBuilder.equal(driver.get("name"), name));
        }

        if (experience != null) {
            predicates.add(criteriaBuilder.equal(driver.get("experience"), experience));
        }

        if (companyId != null) {
            predicates.add(criteriaBuilder.equal(driver.get("companyId"), companyId));
        }

        query.where(predicates.toArray(new Predicate[0]));

        List<Driver> result = entityManager.createQuery(query).getResultList();

        return driverMapper.mapToDto(result);

    }

}

