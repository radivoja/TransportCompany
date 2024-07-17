package com.qinshift.transportCompany.service.impl;

import com.qinshift.transportCompany.dto.Truck;
import com.qinshift.transportCompany.entity.GoodsEntity;
import com.qinshift.transportCompany.entity.TruckEntity;
import com.qinshift.transportCompany.mappers.TruckMapper;
import com.qinshift.transportCompany.repository.GoodsRepository;
import com.qinshift.transportCompany.repository.TruckRepository;
import com.qinshift.transportCompany.service.TruckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TruckServiceImpl implements TruckService {

    private final TruckRepository truckRepository;
    private final GoodsRepository goodsRepository;
    private final TruckMapper truckMapper;

    @Override
    public List<Truck> findAll() {
        return truckMapper.mapToDto(truckRepository.findAll());
    }

    @Override
    public Optional<Truck> getTruck(String id) {
        return truckRepository.findById(id).map(truckMapper::map);
    }

    @Override
    public Optional<Truck> createTruck(Truck truck) {
        if(truckRepository.existsById(truck.getId())){
            return Optional.empty();
        }
        return Optional.of(truckMapper.map(truckRepository.save(truckMapper.map(truck))));

    }

    @Override
    public Optional<Truck> updateTruck(String id, Truck truck) {
        if(truckRepository.existsById(id)) {
            truck.setId(id);
            return Optional.ofNullable(truckMapper.map(truckRepository.save(
                    truckMapper.map(truck))));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Truck> deleteTruck(String id) {
        Optional<TruckEntity> entity = truckRepository.findById(id);
        if (entity.isPresent()) {
            truckRepository.deleteById(id);
            return Optional.of(new Truck());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Truck> findTrucksByGoodsId(String id) {
        return truckMapper.mapToDto(truckRepository.findTrucksByGoodsId(id));
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
