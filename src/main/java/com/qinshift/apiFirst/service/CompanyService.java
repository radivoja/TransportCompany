package com.qinshift.apiFirst.service;

import com.qinshift.apiFirst.entity.CompanyEntity;

import java.util.List;
import java.util.Optional;


public interface CompanyService {
    List<CompanyEntity>  listAll();
    boolean createCompany(CompanyEntity company);
    Optional<CompanyEntity> getCompanyById(String id);
    boolean deleteCompany(String id);
    CompanyEntity updateTruck(String id, CompanyEntity entity);
}
