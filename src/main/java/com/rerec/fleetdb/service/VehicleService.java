package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Vehicle;
import com.rerec.fleetdb.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicle(){
        return vehicleRepository.findAll();
    }

    public void saveVehicle(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }
}
