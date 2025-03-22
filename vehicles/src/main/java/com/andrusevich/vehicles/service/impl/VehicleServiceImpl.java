package com.andrusevich.vehicles.service.impl;

import com.andrusevich.vehicles.constants.VehicleConstants;
import com.andrusevich.vehicles.dto.VehicleDto;
import com.andrusevich.vehicles.entity.Vehicle;
import com.andrusevich.vehicles.exception.ResourceNotFoundException;
import com.andrusevich.vehicles.exception.VehicleAlreadyExistsException;
import com.andrusevich.vehicles.mapper.VehicleMapper;
import com.andrusevich.vehicles.repository.VehiclesRepository;
import com.andrusevich.vehicles.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private VehiclesRepository vehiclesRepository;

    @Override
    public void createVehicle(String mobileNumber) {
        Optional<Vehicle> optionalVehicle = vehiclesRepository.findByMobileNumber(mobileNumber);
        if(optionalVehicle.isPresent()){
            throw new VehicleAlreadyExistsException("Vehicle already registered with given mobileNumber " + mobileNumber);
        }
        vehiclesRepository.save(createNewVehicle(mobileNumber));
    }

    private Vehicle createNewVehicle(String mobileNumber) {
        Vehicle newVehicle = new Vehicle();
        long randomVinNumber = 100000000000L + new Random().nextInt(900000000);
        newVehicle.setVinNumber(Long.toString(randomVinNumber));
        newVehicle.setMobileNumber(mobileNumber);
        newVehicle.setVehicleType(VehicleConstants.VEHICLE_TYPE);
        newVehicle.setTotalLoan(VehicleConstants.NEW_LOAN_LIMIT);
        newVehicle.setAmountPaid(0);
        newVehicle.setOutstandingAmount(VehicleConstants.NEW_LOAN_LIMIT);
        return newVehicle;
    }

    @Override
    public VehicleDto fetchVehicle(String mobileNumber) {
        Vehicle vehicle = vehiclesRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Vehicle", "Mobile Number", mobileNumber)
        );
        return VehicleMapper.mapToVehicleDto(vehicle, new VehicleDto());
    }

    @Override
    public boolean updateVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = vehiclesRepository.findByVinNumber(vehicleDto.getVinNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Vehicle", "Vin Number", vehicleDto.getVinNumber())
        );
        VehicleMapper.mapToVehicle(vehicleDto, vehicle);
        vehiclesRepository.save(vehicle);
        return true;
    }

    @Override
    public boolean deleteVehicle(String mobileNumber) {
        Vehicle vehicle = vehiclesRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Vehicle", "Mobile Number", mobileNumber)
        );
        vehiclesRepository.deleteById(vehicle.getVehicleId());
        return true;
    }
}
