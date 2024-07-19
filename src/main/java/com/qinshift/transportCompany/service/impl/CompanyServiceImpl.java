package com.qinshift.transportCompany.service.impl;

import com.qinshift.transportCompany.dto.Company;
import com.qinshift.transportCompany.entity.CompanyEntity;
import com.qinshift.transportCompany.mappers.CompanyMapper;
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
    private final CompanyMapper companyMapper;

    @Override
    public List<Company> listAll() {
       return companyMapper.mapToDto(companyRepository.findAll());
    }

    @Override
    public Optional<Company> createCompany(Company company) {
        if(companyRepository.existsById(company.getId())){
            return Optional.empty();
        }
        return Optional.of(companyMapper.map(companyRepository.save(companyMapper.map(company))));
    }

    @Override
    public Optional<Company> getCompanyById(Integer id) {
        return companyRepository.findById(id).map(companyMapper::map);
    }

    @Override
    public Optional<Company> deleteCompany(Integer id) {
        Optional<CompanyEntity> entity = companyRepository.findById(id);
        if (entity.isPresent()) {
            companyRepository.deleteById(id);
            return Optional.of(new Company());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Company> updateCompany(Integer id, Company company) {
        if(companyRepository.existsById(id)) {
            company.setId(id);
            return Optional.ofNullable(companyMapper.map(companyRepository.save(
                    companyMapper.map(company))));
        }
        return Optional.empty();
    }
}
