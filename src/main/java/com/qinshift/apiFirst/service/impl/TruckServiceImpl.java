package com.qinshift.apiFirst.service.impl;

import com.qinshift.apiFirst.entity.GoodsEntity;
import com.qinshift.apiFirst.entity.TruckEntity;
import com.qinshift.apiFirst.repository.GoodsRepository;
import com.qinshift.apiFirst.repository.TruckRepository;
import com.qinshift.apiFirst.service.TruckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TruckServiceImpl implements TruckService {

    private final TruckRepository truckRepository;
    private final GoodsRepository goodsRepository;

    @Override
    public List<TruckEntity> findAll() {
        return truckRepository.findAll();
    }

    @Override
    public Optional<TruckEntity> getTruck(String id) {
        return truckRepository.findById(id);
    }

    @Override
    public boolean createTruck(TruckEntity truck) {
        if(truckRepository.existsById(truck.getId())) {
            return false;
        }
        truckRepository.save(truck);
        return true;
    }

    @Override
    public TruckEntity updateTruck(String id, TruckEntity truck) {
        if(truckRepository.existsById(id)){
            truck.setId(id);
            return truckRepository.save(truck);
        }
        return null;
    }

    @Override
    public boolean deleteTruck(String id) {
        if(truckRepository.existsById(id)){
            truckRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<TruckEntity> findTrucksByGoodsId(String id) {
        return truckRepository.findTrucksByGoodsId(id);
    }

    @Override
    public boolean assignTruckToGoods(String truckId, String goodsId) {
        Optional<TruckEntity> truck = truckRepository.findById(truckId);
        Optional<GoodsEntity> goods = goodsRepository.findById(goodsId);

        if(truck.isEmpty() || goods.isEmpty()){
            return false;
        }

        List<GoodsEntity> listOfGoods = truck.get().getGoods();
        listOfGoods.add(goods.get());

        List<TruckEntity> listOfTrucks = goods.get().getTrucks();
        listOfTrucks.add(truck.get());

        truck.get().setGoods(listOfGoods);
        goods.get().setTrucks(listOfTrucks);

        truckRepository.save(truck.get());
        goodsRepository.save(goods.get());

        return true;
    }

}
