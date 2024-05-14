package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Designation;
import com.rerec.fleetdb.repository.DesignationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesignationService {

    private final DesignationRepository designationRepository;

    public DesignationService(DesignationRepository designationRepository){
        this.designationRepository = designationRepository;
    }

    public List<Designation> getAllDesignation(){
        return designationRepository.findAll();
    }

    public void saveDesignation(Designation designation){
        designationRepository.save(designation);
    }

    public Designation getDesignationByID(Long id){
        Optional<Designation> optional = designationRepository.findById(id);

        Designation designation = null;

        if(optional.isPresent()){
            designation = optional.get();
        } else {
            throw new RuntimeException(designation + " not found");
        }

        return designation;
    }

    public void deleteDesignation(Long id){
        this.designationRepository.deleteById(id);
    }
}
