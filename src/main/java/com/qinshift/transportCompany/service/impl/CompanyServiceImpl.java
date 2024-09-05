package com.qinshift.transportCompany.service.impl;

import com.qinshift.transportCompany.dto.CompanyDto;
import com.qinshift.transportCompany.entity.Company;
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
    public List<CompanyDto> getCompanies() {
        return companyMapper.mapToDto(companyRepository.findAll());
    }
	
	@Override
    public Optional<CompanyDto> getCompanyById(Integer id) {
        return companyRepository.findById(id).map(companyMapper::map);
    }
	
    @Override
    public Optional<CompanyDto> createCompany(CompanyDto companyDto) {
        if(companyRepository.existsById(companyDto.getId())){
            return Optional.empty();
        }
        return Optional.of(companyMapper.map(companyRepository.save(companyMapper.map(companyDto))));
    }

    @Override
    public Optional<CompanyDto> updateCompany(Integer id, CompanyDto companyDto) {
        if(companyRepository.existsById(id)) {
            companyDto.setId(id);
            return Optional.ofNullable(companyMapper.map(companyRepository.save(
                companyMapper.map(companyDto))));
        }
        return Optional.empty();
    }

    @Override
    public Optional<CompanyDto> deleteCompany(Integer id) {
        Optional<Company> entity = companyRepository.findById(id);
        if (entity.isPresent()) {
            companyRepository.deleteById(id);
            return Optional.of(new CompanyDto());
        } else {
            return Optional.empty();
        }
    }
}
