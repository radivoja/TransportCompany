package com.qinshift.transportCompany.entity;

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

    private Integer weight ;

    private Integer age;

    @OneToOne
    private DriverEntity driver;

    @ToString.Exclude
    @ManyToMany(mappedBy = "trucks")
    private List<GoodsEntity> goods;
}
