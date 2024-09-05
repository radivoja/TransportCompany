package com.qinshift.transportCompany.service;
import com.qinshift.transportCompany.dto.CompanyDto;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<CompanyDto> getCompanies();
    Optional<CompanyDto> getCompanyById(Integer id);
    Optional<CompanyDto> createCompany(CompanyDto companyDto);
    Optional<CompanyDto> updateCompany(Integer id, CompanyDto companyDto);
    Optional<CompanyDto> deleteCompany(Integer id);


}
