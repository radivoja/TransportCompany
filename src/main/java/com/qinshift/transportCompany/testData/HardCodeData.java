package com.qinshift.transportCompany.testData;

import com.qinshift.transportCompany.entity.CompanyEntity;
import com.qinshift.transportCompany.entity.DriverEntity;
import com.qinshift.transportCompany.entity.GoodsEntity;
import com.qinshift.transportCompany.entity.TruckEntity;
import com.qinshift.transportCompany.repository.CompanyRepository;
import com.qinshift.transportCompany.repository.DriverRepository;
import com.qinshift.transportCompany.repository.GoodsRepository;
import com.qinshift.transportCompany.repository.TruckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class HardCodeData implements CommandLineRunner {

    private final CompanyRepository companyRepository;
    private final TruckRepository truckRepository;
    private final GoodsRepository goodsRepository;
    private final DriverRepository driverRepository;

    @Override
    public void run(String... args) throws Exception {
        //Company data
        CompanyEntity jareAndCuturaCo = CompanyEntity.builder()
                .id("C-1")
                .name("Jare & Cutura CO")
                .location("Beograd")
                .build();
        companyRepository.save(jareAndCuturaCo);

        // Driver data
        DriverEntity jare = DriverEntity.builder()
                .id("D-1")
                .name("Jaric T Zivadin")
                .experience(20)
                .company(jareAndCuturaCo)
                .build();
        DriverEntity paja = DriverEntity.builder()
                .id("D-2")
                .name("Pavle Cutura")
                .experience(20)
                .company(jareAndCuturaCo)
                .build();
        driverRepository.save(jare);
        driverRepository.save(paja);


        // Truck data
        TruckEntity jareTruck = TruckEntity.builder()
                .id("T-1")
                .age(15)
                .weight(25)
                .driver(jare)
                .build();
        TruckEntity pajaTruck = TruckEntity.builder()
                .id("T-2")
                .age(10)
                .weight(30)
                .driver(paja)
                .build();
        truckRepository.save(jareTruck);
        truckRepository.save(pajaTruck);

        List<TruckEntity> trucks = new ArrayList<>();
        trucks.add(jareTruck);
        trucks.add(pajaTruck);
        //Goods data
        GoodsEntity coal = GoodsEntity.builder()
                .id("G-1")
                .name("Coal")
                .category("Resource")
                .build();
        GoodsEntity potato = GoodsEntity.builder()
                .id("G-2")
                .name("Potato")
                .category("Food")
                .trucks(trucks)
                .build();

        goodsRepository.save(coal);
        goodsRepository.save(potato);

    }
}
