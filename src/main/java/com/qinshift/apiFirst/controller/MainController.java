package com.qinshift.apiFirst.controller;

import com.qinshift.apiFirst.dto.Company;
import com.qinshift.apiFirst.dto.Driver;
import com.qinshift.apiFirst.dto.Goods;
import com.qinshift.apiFirst.dto.Truck;
import com.qinshift.apiFirst.entity.CompanyEntity;
import com.qinshift.apiFirst.entity.DriverEntity;
import com.qinshift.apiFirst.entity.TruckEntity;
import com.qinshift.apiFirst.mappers.CompanyMapper;
import com.qinshift.apiFirst.mappers.DriverMapper;
import com.qinshift.apiFirst.mappers.GoodsMapper;
import com.qinshift.apiFirst.mappers.TruckMapper;
import com.qinshift.apiFirst.service.CompanyService;
import com.qinshift.apiFirst.service.DriverService;
import com.qinshift.apiFirst.service.GoodsService;
import com.qinshift.apiFirst.service.TruckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MainController implements ApiFirstApi {

    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    private final DriverService driverService;
    private final DriverMapper driverMapper;

    private final TruckService truckService;
    private final TruckMapper truckMapper;

    private final GoodsService goodsService;
    private final GoodsMapper goodsMapper;

    @Override
    public ResponseEntity<List<Company>> getCompanies() {
        List<Company> companies = companyMapper.mapToEntity(companyService.listAll());
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Company> getCompanyById(String id) {
        Optional<CompanyEntity> company = companyService.getCompanyById(id);
        if(company.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(companyMapper.map(company.get()), HttpStatus.FOUND);
    }


    @Override
    public ResponseEntity<String> createDriver(Driver body) {
        DriverEntity driver = driverMapper.map(body);
        if(driverService.createDriver(driver) != null){
            return new ResponseEntity<>(driver.toString() , HttpStatus.OK);
        }
        return new ResponseEntity<>("Already exist" , HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<Driver>> getDrivers() {

        List<Driver> drivers = driverMapper.listEntityToDto(driverService.listAll());
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Goods>> getGoods() {
        List<Goods> goods = goodsMapper.mapToDto(goodsService.findAll());
        return new ResponseEntity<>(goods , HttpStatus.OK);
    }

    // GET by id
    @Override
    public ResponseEntity<Truck> getTruck(String id) {
        if(truckService.getTruck(id).isPresent()){
            Truck truck = truckMapper.map(truckService.getTruck(id).get());
            return new ResponseEntity<>(truck, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // GET list
    @Override
    public ResponseEntity<List<Truck>> getTrucks() {
        List<Truck> trucks = truckMapper.mapToDto(truckService.findAll());
        return new ResponseEntity<>(trucks , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Truck>> getTrucksByGoodsId(String goodsId) {
        List<Truck> trucks = truckMapper.mapToDto(truckService.findTrucksByGoodsId(goodsId));
        return new ResponseEntity<>(trucks, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Company> updateCompany(String id, Company body) {
        CompanyEntity company = companyService.updateTruck(id, companyMapper.map(body));
        if(company == null){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(companyMapper.map(company), HttpStatus.OK);
    }

    // POST
    @Override
    public ResponseEntity<String> createTruck(Truck body) {
        TruckEntity truck = truckMapper.map(body);
        if(truckService.createTruck(truck)){
            return new ResponseEntity<>("Already exist" , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteCompanyById(String idd) {
        if(companyService.deleteCompany(idd)){
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // PUT
    @Override
    public ResponseEntity<Truck> updateTruck(String idt, Truck body) {
        TruckEntity truck = truckService.updateTruck(idt, truckMapper.map(body));
        if(truck == null){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(truckMapper.map(truck), HttpStatus.OK);
    }

    // DELETE
    @Override
    public ResponseEntity<String> deleteTruck(String idd) {
        if(truckService.deleteTruck(idd)){
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    @Override
    public ResponseEntity<String> assignTruckToGoods(String truckId, String goodsId) {
        if(truckService.assignTruckToGoods(truckId, goodsId)){
            return new ResponseEntity<>("Successfully assigned", HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

    }

    @Override
    public ResponseEntity<String> createCompany(Company body) {
        CompanyEntity company = companyMapper.map(body);
        if(companyService.createCompany(company)){
            return new ResponseEntity<>("Already exist", HttpStatus.OK);
        }

        return new ResponseEntity<>("Successfully created", HttpStatus.CREATED);
    }

}