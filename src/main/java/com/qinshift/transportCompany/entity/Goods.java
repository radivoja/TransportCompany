package com.qinshift.transportCompany.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "goods")
public class Goods {
    @Id
    private Integer id;
    private String name;
    private Integer quantity;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "shipping_goods")
    private List<Shipment> shipments;
}
