package com.qinshift.transportCompany.service;


import com.qinshift.transportCompany.dto.CompanyDto;

import java.util.List;

public interface CompanySearchService {
    List<CompanyDto> searchCompanies(String name, String location, Integer founded);
}
