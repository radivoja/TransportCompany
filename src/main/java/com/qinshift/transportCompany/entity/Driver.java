package com.qinshift.transportCompany.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "driver")
public class Driver {

    @Id
    private Integer id;
    private String name;
    private int experience;

    @OneToOne
    private Truck truck;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

}
