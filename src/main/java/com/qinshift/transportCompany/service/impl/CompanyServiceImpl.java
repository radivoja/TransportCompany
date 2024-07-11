package com.qinshift.transportCompany.service.impl;

import com.qinshift.transportCompany.entity.CompanyEntity;
import com.qinshift.transportCompany.repository.CompanyRepository;
import com.qinshift.transportCompany.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<CompanyEntity> listAll() {
       return companyRepository.findAll();
    }

    @Override
    public boolean createCompany(CompanyEntity company) {
        if(companyRepository.existsById(company.getId())) {
            return false;
        }
        companyRepository.save(company);
        return true;
    }

    @Override
    public Optional<CompanyEntity> getCompanyById(String id) {
        return companyRepository.findById(id);
    }

    @Override
    public boolean deleteCompany(String id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public CompanyEntity updateTruck(String id, CompanyEntity company) {
        if(companyRepository.existsById(id)){
            company.setId(id);
            return companyRepository.save(company);
        }
        return null;
    }
}
