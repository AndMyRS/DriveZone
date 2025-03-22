package com.andrusevich.vehicles.mapper;

import com.andrusevich.vehicles.dto.VehicleDto;
import com.andrusevich.vehicles.entity.Vehicle;

public class VehicleMapper {

    public static VehicleDto mapToVehicleDto(Vehicle vehicle, VehicleDto vehicleDto) {
        vehicleDto.setVinNumber(vehicle.getVinNumber());
        vehicleDto.setVehicleType(vehicle.getVehicleType());
        vehicleDto.setMobileNumber(vehicle.getMobileNumber());
        vehicleDto.setTotalLoan(vehicle.getTotalLoan());
        vehicleDto.setAmountPaid(vehicle.getAmountPaid());
        vehicleDto.setOutstandingAmount(vehicle.getOutstandingAmount());
        return vehicleDto;
    }

    public static Vehicle mapToVehicle(VehicleDto vehicleDto, Vehicle vehicle) {
        vehicle.setVinNumber(vehicleDto.getVinNumber());
        vehicle.setVehicleType(vehicleDto.getVehicleType());
        vehicle.setMobileNumber(vehicleDto.getMobileNumber());
        vehicle.setTotalLoan(vehicleDto.getTotalLoan());
        vehicle.setAmountPaid(vehicleDto.getAmountPaid());
        vehicle.setOutstandingAmount(vehicleDto.getOutstandingAmount());
        return vehicle;
    }
}
