package com.andrusevich.vehicles.service;

import com.andrusevich.vehicles.dto.VehicleDto;

public interface VehicleService {

    void createVehicle(String mobileNumber);


    VehicleDto fetchVehicle(String mobileNumber);

    boolean updateVehicle(VehicleDto loansDto);

    boolean deleteVehicle(String mobileNumber);

}
