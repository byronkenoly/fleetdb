package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Make;
import com.rerec.fleetdb.entities.Vehicle;
import com.rerec.fleetdb.repository.MakeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakeService {

    private final MakeRepository makeRepository;

    public MakeService(MakeRepository makeRepository){
        this.makeRepository = makeRepository;
    }

    public List<Make> getAllMake(){
        return makeRepository.findAll();
    }

    public void saveMake(Make make){
        makeRepository.save(make);
    }

    public Make getMakeByID(Long id){
        Optional<Make> optional = makeRepository.findById(id);

        Make make = null;

        if(optional.isPresent()){
            make = optional.get();
        } else {
            throw new RuntimeException(make + " not found");
        }

        return make;
    }

    public void deleteMake(Long id){
        this.makeRepository.deleteById(id);
    }

    public Page<Make> findPaginated(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return this.makeRepository.findAll(pageable);
    }
}
