package com.qinshift.transportCompany.service;

import com.qinshift.transportCompany.dto.CompanyDto;

import java.util.List;
import java.util.Optional;


public interface CompanyService {
    List<CompanyDto>  listAll();
    Optional<CompanyDto> createCompany(CompanyDto company);
    Optional<CompanyDto> getCompanyById(Integer id);
    Optional<CompanyDto> deleteCompany(Integer id);
    Optional<CompanyDto> updateCompany(Integer id, CompanyDto company);
}
