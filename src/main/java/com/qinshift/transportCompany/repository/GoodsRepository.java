package com.qinshift.transportCompany.repository;

import com.qinshift.transportCompany.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<GoodsEntity, Integer> {
}
