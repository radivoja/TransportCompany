package com.qinshift.apiFirst.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company")
public class CompanyEntity {
    @Id
    private String id;
    private String name;
    private String location;

    @ToString.Exclude
    @OneToMany
    private List<DriverEntity> drivers;
}
