package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Region;
import com.rerec.fleetdb.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository){
        this.regionRepository = regionRepository;
    }

    public List<Region> getAllRegion(){
        return regionRepository.findAll();
    }

    public void saveRegion(Region region){
        regionRepository.save(region);
    }

    public Region getRegionByID(Long id){
        Optional<Region> optional = regionRepository.findById(id);

        Region region = null;

        if(optional.isPresent()){
            region = optional.get();
        } else {
            throw new RuntimeException(region + " not found");
        }

        return region;
    }

    public void deleteRegion(Long id){
        this.regionRepository.deleteById(id);
    }
}
