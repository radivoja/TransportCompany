package com.qinshift.apiFirst.entity;

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
    private String id;

    private Integer weight ;

    private Integer age;

    @OneToOne
    private DriverEntity driver;

    @ToString.Exclude
    @ManyToMany(mappedBy = "trucks")
    private List<GoodsEntity> goods;
}
