package com.qinshift.apiFirst.repository;

import com.qinshift.apiFirst.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, String> {
}
