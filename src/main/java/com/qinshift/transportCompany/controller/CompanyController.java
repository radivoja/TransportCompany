package com.qinshift.transportCompany.controller;

import com.qinshift.transportCompany.dto.CompanyDto;
import com.qinshift.transportCompany.service.CompanySearchService;
import com.qinshift.transportCompany.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CompanyController implements CompanyApi {
    private final CompanyService companyService;
    private final CompanySearchService companySearchService;

    @Override
    public ResponseEntity<String> createCompany(CompanyDto body) {
        if (companyService.createCompany(body).isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Already Exist");

    }

    @Override
    public ResponseEntity<String> deleteCompanyById(Integer idd) {
        if(companyService.deleteCompany(idd).isPresent()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found with "+ idd);
        }
    }

    @Override
    public ResponseEntity<List<CompanyDto>> getCompanies() {
        return ResponseEntity.ok(companyService.listAll());
    }

    @Override
    public ResponseEntity<CompanyDto> getCompanyById(Integer id) {
        return ResponseEntity.of(companyService.getCompanyById(id));
    }

    @Override
    public ResponseEntity<List<CompanyDto>> searchByCriteriaApi(String name, String location, Integer founded) {
        return ResponseEntity.ok(companySearchService.searchCompanies(name, location, founded));
    }

    @Override
    public ResponseEntity<CompanyDto> updateCompany(Integer idp, CompanyDto body) {
        return ResponseEntity.of(companyService.updateCompany(idp, body));
    }
}
