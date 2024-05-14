package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Contractor;
import com.rerec.fleetdb.repository.ContractorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractorService {

    private final ContractorRepository contractorRepository;

    public ContractorService(ContractorRepository contractorRepository){
        this.contractorRepository = contractorRepository;
    }

    public List<Contractor> getAllContractor(){
        return contractorRepository.findAll();
    }

    public void saveContractor(Contractor contractor){
        contractorRepository.save(contractor);
    }

    public Contractor getContractorByID(Long id){
        Optional<Contractor> optional = contractorRepository.findById(id);

        Contractor contractor = null;

        if(optional.isPresent()){
            contractor = optional.get();
        } else {
            throw new RuntimeException(contractor + " not found");
        }

        return contractor;
    }

    public void deleteContractor(Long id){
        this.contractorRepository.deleteById(id);
    }
}
