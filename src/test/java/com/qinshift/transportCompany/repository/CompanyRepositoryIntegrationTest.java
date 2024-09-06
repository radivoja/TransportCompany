package com.qinshift.transportCompany.repository;

import com.qinshift.transportCompany.entity.Company;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
public class CompanyRepositoryIntegrationTest {
    @Autowired
    private CompanyRepository companyRepository;

    public static Company testDataA(){
        return Company.builder()
                .id(501)
                .name("FedEx")
                .location("Memphis, TN")
                .build();

    }
    public static Company testDataB(){
        return Company.builder()
                .id(502)
                .name("DHL Express")
                .location("Plantation, FL")
                .build();

    }

    @Test
    public void testSaveAndFindById() {
        Company companyA = testDataA();
        companyRepository.save(companyA);
        Optional<Company> result = companyRepository.findById(companyA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(companyA);
    }

    @Test
    public void testSaveAndFindAll() {
        Company companyA = testDataA();
        companyRepository.save(companyA);

        Company companyB = testDataB();
        companyRepository.save(companyB);

        Iterable<Company> result = companyRepository.findAll();
        assertThat(result)
                .hasSizeGreaterThan(2)
                .contains(companyA, companyB);
    }

    @Test
    public void testUpdate() {
        Company companyA = testDataA();

        companyRepository.save(companyA);

        companyA.setName("UPDATED");
        companyRepository.save(companyA);

        Optional<Company> result = companyRepository.findById(companyA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(companyA);
    }

    @Test
    public void testDelete() {
        Company companyA = testDataA();

        companyRepository.save(companyA);

        companyRepository.deleteById(companyA.getId());

        Optional<Company> result = companyRepository.findById(companyA.getId());
        assertThat(result).isEmpty();
    }
}
