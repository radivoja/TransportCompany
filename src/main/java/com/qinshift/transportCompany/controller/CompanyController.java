package com.qinshift.transportCompany.controller;

import com.qinshift.transportCompany.dto.Company;
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

    @Override
    public ResponseEntity<String> createCompany(Company body) {
        if (companyService.createCompany(body).isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Already Exist");

    }

    @Override
    public ResponseEntity<String> deleteCompanyById(Integer idd) {
        if(companyService.deleteCompany(idd).isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found with "+ idd);
        }
    }

    @Override
    public ResponseEntity<List<Company>> getCompanies() {
        return ResponseEntity.ok(companyService.listAll());
    }

    @Override
    public ResponseEntity<Company> getCompanyById(Integer id) {
        return ResponseEntity.of(companyService.getCompanyById(id));
    }

    @Override
    public ResponseEntity<Company> updateCompany(Integer idp, Company body) {
        return ResponseEntity.of(companyService.updateCompany(idp, body));
    }
}
