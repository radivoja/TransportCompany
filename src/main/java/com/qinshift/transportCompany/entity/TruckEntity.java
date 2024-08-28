package com.qinshift.transportCompany.entity;

import com.qinshift.transportCompany.entity.enums.FuelType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "truck")
public class TruckEntity {

    @Id
    private Integer id;

    private Integer vehicleWeight;

    private String model;

    private String manufacturer;

    private Integer yearManufactured;

    private Integer horsePower;

    private Integer torque;

    private Double cargoCapacity;

    private Boolean aerodynamics;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @OneToOne
    private DriverEntity driver;

    @OneToMany(mappedBy = "truck")
    private List<ShipmentEntity> shipments;


}
