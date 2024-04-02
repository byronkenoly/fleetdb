package com.rerec.fleetdb.service;

import com.rerec.fleetdb.repository.MileageRepository;
import org.springframework.stereotype.Service;

@Service
public class MileageSummaryService {

    private final MileageRepository mileageRepository;

    public MileageSummaryService(MileageRepository mileageRepository){
        this.mileageRepository = mileageRepository;
    }
}
