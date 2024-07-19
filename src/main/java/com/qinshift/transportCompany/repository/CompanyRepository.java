package com.qinshift.transportCompany.repository;

import com.qinshift.transportCompany.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
}
