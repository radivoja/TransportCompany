package com.qinshift.transportCompany.service.impl;

import com.qinshift.transportCompany.dto.CompanyDto;
import com.qinshift.transportCompany.entity.Company;
import com.qinshift.transportCompany.mappers.CompanyMapper;
import com.qinshift.transportCompany.service.CompanySearchService;
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
public class CriteriaApiCompanySearchServiceImpl implements CompanySearchService {

    private final CompanyMapper companyMapper;
    private final EntityManager entityManager;


    @Override
    public List<CompanyDto> searchCompanies(String name, String location, Integer founded) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Company> query = criteriaBuilder.createQuery(Company.class);
        Root<Company> company = query.from(Company.class);

        List<Predicate> predicates = new ArrayList<>();


        if (name != null && !name.isEmpty()) {
            predicates.add(criteriaBuilder.equal(company.get("name"), name));
        }

        if (location != null && !location.isEmpty()) {
            predicates.add(criteriaBuilder.equal(company.get("location"), location));
        }

        if (founded != null) {
            predicates.add(criteriaBuilder.equal(company.get("founded"), founded));
        }

        query.where(predicates.toArray(new Predicate[0]));

        List<Company> result = entityManager.createQuery(query).getResultList();

        return companyMapper.mapToDto(result);

    }

}

