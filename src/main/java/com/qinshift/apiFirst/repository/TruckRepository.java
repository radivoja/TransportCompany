package com.qinshift.apiFirst.repository;

import com.qinshift.apiFirst.entity.TruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TruckRepository extends JpaRepository<TruckEntity, String> {
    List<TruckEntity> findTrucksByGoodsId(String id);
}
