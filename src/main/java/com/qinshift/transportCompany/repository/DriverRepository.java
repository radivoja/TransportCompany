package com.qinshift.transportCompany.repository;

import com.qinshift.transportCompany.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Integer> {
}
