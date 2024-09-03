package com.qinshift.transportCompany.service.impl;

import com.qinshift.transportCompany.dto.GoodsDto;
import com.qinshift.transportCompany.entity.Goods;
import com.qinshift.transportCompany.mappers.GoodsMapper;
import com.qinshift.transportCompany.service.GoodsSearchService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CriteriaApiGoodsSearchServiceImpl implements GoodsSearchService {

    private final GoodsMapper goodsMapper;
    private final EntityManager entityManager;


    @Override
    public List<GoodsDto> searchGoods(String name, Integer quantity) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Goods> query = criteriaBuilder.createQuery(Goods.class);
        Root<Goods> goods = query.from(Goods.class);

        List<Predicate> predicates = new ArrayList<>();


        if (name != null && !name.isEmpty()) {
            predicates.add(criteriaBuilder.equal(goods.get("name"), name));
        }

        if (quantity != null) {
            predicates.add(criteriaBuilder.equal(goods.get("quantity"), quantity));
        }


        query.where(predicates.toArray(new Predicate[0]));

        List<Goods> result = entityManager.createQuery(query).getResultList();

        return goodsMapper.mapToDto(result);

    }

}

