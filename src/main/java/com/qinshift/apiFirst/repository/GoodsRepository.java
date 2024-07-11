package com.qinshift.apiFirst.repository;

import com.qinshift.apiFirst.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<GoodsEntity, String> {
}
