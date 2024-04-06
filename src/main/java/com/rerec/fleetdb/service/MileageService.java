package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Mileage;
import com.rerec.fleetdb.repository.MileageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MileageService {

    private final MileageRepository mileageRepository;

    public MileageService(MileageRepository mileageRepository){
        this.mileageRepository = mileageRepository;
    }

    public List<Mileage> getAllMileage(){
        return mileageRepository.findAll();
    }

    public void saveMileage(Mileage mileage){
        mileageRepository.save(mileage);
    }
}
