package com.qinshift.transportCompany.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "shipment")
public class Shipment {

    @Id
    private Long id;

    @CreationTimestamp
    private LocalDate dateLoaded;

    private String destination;

    private Double distance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "truck_id")
    private Truck truck;

    @ManyToMany(mappedBy = "shipments")
    private List<Goods> goods;

}
