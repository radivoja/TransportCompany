package com.qinshift.apiFirst.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "driver")
public class DriverEntity {

    @Id
    private String id;
    private String name;
    private int experience;

    @OneToOne
    private TruckEntity truck;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    private CompanyEntity company;

}
