package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Mileage;
import com.rerec.fleetdb.entities.Vehicle;
import com.rerec.fleetdb.repository.MileageRepository;
import com.rerec.fleetdb.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MileageService {

    private final MileageRepository mileageRepository;

    private final VehicleRepository vehicleRepository;

    public MileageService(MileageRepository mileageRepository, VehicleRepository vehicleRepository){

        this.mileageRepository = mileageRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public List<Mileage> getAllMileage(){
        return mileageRepository.findAll();
    }

    public List<Vehicle> getAllVehicle(){
        return vehicleRepository.findAll();
    }

    public Mileage getMileageByID(Long id){
        Optional<Mileage> optional = mileageRepository.findById(id);

        Mileage mileage = null;

        if(optional.isPresent()){
            mileage = optional.get();
        } else {
            throw new RuntimeException(id + " not found");
        }

        return mileage;
    }

    public void saveMileage(Mileage mileage){
        mileageRepository.save(mileage);
    }

    public void deleteMileage(Long no){
        this.mileageRepository.deleteById(no);
    }
}
