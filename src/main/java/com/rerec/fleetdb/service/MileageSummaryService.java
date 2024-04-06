package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.MileageSummary;
import com.rerec.fleetdb.repository.MileageRepository;
import com.rerec.fleetdb.repository.MileageSummaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MileageSummaryService {

    private final MileageSummaryRepository mileageSummaryRepository;

    public MileageSummaryService(MileageSummaryRepository mileageSummaryRepository){
        this.mileageSummaryRepository = mileageSummaryRepository;
    }

    public List<MileageSummary> getAllMileageSummary(){
        return mileageSummaryRepository.findAll();
    }

    public void saveMileageSummary(MileageSummary mileageSummary){
        mileageSummaryRepository.save(mileageSummary);
    }
}
