package com.andrusevich.vehicles.repository;

import com.andrusevich.vehicles.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findByMobileNumber(String mobileNumber);

    Optional<Vehicle> findByVinNumber(String vinNumber);
}
