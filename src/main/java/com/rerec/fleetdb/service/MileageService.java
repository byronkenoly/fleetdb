package com.rerec.fleetdb.service;

import com.rerec.fleetdb.repository.MileageRepository;
import org.springframework.stereotype.Service;

@Service
public class MileageService {

    private final MileageRepository mileageRepository;

    public MileageService(MileageRepository mileageRepository){
        this.mileageRepository = mileageRepository;
    }
}
