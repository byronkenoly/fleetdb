package com.rerec.fleetdb.service;

import com.rerec.fleetdb.repository.DataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    private final DataRepository dataRepository;

    public DataService(DataRepository dataRepository){
        this.dataRepository = dataRepository;
    }

    public List<Object[]> getCombinedData(){
        List<Object[]> data = dataRepository.findCombinedData();

        for (Object[] row : data){

            String serviceType = (String) row[2];
            Float lastServiceMileage = (Float) row[3];
            float distanceCovered = ((Double) row[1]).floatValue();

            Float remainingDistance = calcRemainingDistance(serviceType, lastServiceMileage, distanceCovered);
            row[1] = remainingDistance;
        }

        return data;
    }

    private Float calcRemainingDistance(String serviceType, Float lastServiceMileage, Float distanceCovered){
        Float serviceInterval = getServiceInterval(serviceType);
        if (serviceInterval != null) {
            return (lastServiceMileage + serviceInterval) - distanceCovered;
        }
        return null; // Handle unknown service types
    }

    private Float getServiceInterval(String serviceType){
        switch (serviceType){
            case "Oil change":
                return 5000.0f;
            default:
                return null;
        }
    }
}
