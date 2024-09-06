package com.qinshift.transportCompany.service;

import com.qinshift.transportCompany.dto.CompanyDto;
import com.qinshift.transportCompany.entity.Company;
import com.qinshift.transportCompany.mappers.CompanyMapper;
import com.qinshift.transportCompany.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
@WebMvcTest(CompanyService.class)
public class CompanyServiceIntegrationTest {
    @MockBean
    private CompanyRepository companyRepository;

    @MockBean
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyService companyService;

    public static Company CompanyA(){
        return Company.builder().id(1).name("Landstar System").location("Jacksonville, FL").founded(1968).build();
    }

    public static Company CompanyB(){
        return Company.builder().id(2).name("Ryder System, Inc.").location("Miami, FL").founded(1933).build();
    }

    @Test
    public void testListAll() {
        List<Company> companies = List.of(CompanyA(), CompanyB());
        List<CompanyDto> companiesDto = companyMapper.mapToDto(companies);

        when(companyRepository.findAll()).thenReturn(companies);
        when(companyMapper.mapToDto(companies)).thenReturn(companiesDto);

        List<CompanyDto> result = companyService.getCompanies();

        assertEquals(companiesDto, result);
    }

    @Test
    public void testCreateCompany() {
        Company company = CompanyA();
        CompanyDto companyDto = new CompanyDto().id(1).name("Landstar System").location("Jacksonville, FL").founded(1968);

        when(companyRepository.existsById(1)).thenReturn(false);
        when(companyMapper.map(companyDto)).thenReturn(company);
        when(companyRepository.save(company)).thenReturn(company);
        when(companyMapper.map(company)).thenReturn(companyDto);

        Optional<CompanyDto> result = companyService.createCompany(companyDto);

        assertTrue(result.isPresent());
        assertEquals(companyDto, result.get());

    }

    @Test
    public void testGetCompanyById() {
        Company company = CompanyA();
        CompanyDto companyDto = new CompanyDto().id(1).name("Landstar System").location("Jacksonville, FL").founded(1968);

        when(companyRepository.findById(company.getId())).thenReturn(Optional.of(company));
        when(companyMapper.map(company)).thenReturn(companyDto);

        Optional<CompanyDto> result = companyService.getCompanyById(1);

        assertTrue(result.isPresent());
        assertEquals(companyDto, result.get());
    }

    @Test
    public void testDeleteCompany() {
        Company company = CompanyA();

        when(companyRepository.findById(company.getId())).thenReturn(Optional.of(company));
        doNothing().when(companyRepository).deleteById(company.getId());

        Optional<CompanyDto> result = companyService.deleteCompany(company.getId());

        assertTrue(result.isPresent());
        assertEquals(new CompanyDto(), result.get());
    }

    @Test
    public void testUpdateCompany() {
        CompanyDto updatedCompanyDto = new CompanyDto().name("Updated Company").location("Updated Location").founded(2021);
        Company company = CompanyB();

        when(companyRepository.existsById(company.getId())).thenReturn(true);
        when(companyMapper.map(updatedCompanyDto)).thenReturn(company);
        when(companyRepository.save(company)).thenReturn(company);
        when(companyMapper.map(company)).thenReturn(updatedCompanyDto);

        Optional<CompanyDto> result = companyService.updateCompany(company.getId(), updatedCompanyDto);

        assertTrue(result.isPresent());
        assertEquals(updatedCompanyDto, result.get());
    }
}

