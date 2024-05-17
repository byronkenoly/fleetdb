package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Make;
import com.rerec.fleetdb.entities.Region;
import com.rerec.fleetdb.entities.Vehicle;
import com.rerec.fleetdb.repository.MakeRepository;
import com.rerec.fleetdb.repository.RegionRepository;
import com.rerec.fleetdb.repository.VehicleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final MakeRepository makeRepository;
    private final RegionRepository regionRepository;

    public VehicleService(VehicleRepository vehicleRepository, MakeRepository makeRepository, RegionRepository regionRepository){
        this.vehicleRepository = vehicleRepository;
        this.makeRepository = makeRepository;
        this.regionRepository = regionRepository;
    }

    public List<Vehicle> getAllVehicle(){
        return vehicleRepository.findAll();
    }

    public List<Make> getAllMake(){
        return makeRepository.findAll();
    }

    public List<Region> getAllRegion(){
        return regionRepository.findAll();
    }

    public void saveVehicle(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicleByNumberPlate(String numberPlate){
        Optional<Vehicle> optional = vehicleRepository.findById(numberPlate);

        Vehicle vehicle = null;

        if(optional.isPresent()){
            vehicle = optional.get();
        } else {
            throw new RuntimeException(numberPlate + " not found");
        }

        return vehicle;
    }

    public void deleteVehicle(String numberPlate){
        this.vehicleRepository.deleteById(numberPlate);
    }

    public Page<Vehicle> paginateRecords(int pageNo, int pageSize){
        //Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.vehicleRepository.findAll(pageable);
        //return this.vehicleRepository.findAll(sort);
    }
}
