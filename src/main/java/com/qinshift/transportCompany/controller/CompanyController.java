package com.qinshift.transportCompany.controller;

import com.qinshift.transportCompany.dto.Company;
import com.qinshift.transportCompany.entity.CompanyEntity;
import com.qinshift.transportCompany.mappers.CompanyMapper;
import com.qinshift.transportCompany.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class CompanyController implements CompanyApi {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @Override
    public ResponseEntity<String> createCompany(Company body) {
        CompanyEntity company = companyMapper.map(body);
        if(companyService.createCompany(company)){
            return new ResponseEntity<>("Already exist", HttpStatus.OK);
        }

        return new ResponseEntity<>("Successfully created", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteCompanyById(String idd) {
        if(companyService.deleteCompany(idd)){
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Company>> getCompanies() {
        List<Company> companies = companyMapper.mapToEntity(companyService.listAll());
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Company> getCompanyById(String id) {
        Optional<CompanyEntity> company = companyService.getCompanyById(id);
        if(company.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(companyMapper.map(company.get()), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<Company> updateCompany(String idp, Company body) {
        CompanyEntity company = companyService.updateTruck(idp, companyMapper.map(body));
        if(company == null){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(companyMapper.map(company), HttpStatus.OK);
    }
}
