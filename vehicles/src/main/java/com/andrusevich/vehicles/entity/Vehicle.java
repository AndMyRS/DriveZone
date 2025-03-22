package com.andrusevich.vehicles.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Vehicle extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    private String mobileNumber;

    private String vinNumber;

    private String vehicleType;

    private int totalLoan;

    private int amountPaid;

    private int outstandingAmount;

}
