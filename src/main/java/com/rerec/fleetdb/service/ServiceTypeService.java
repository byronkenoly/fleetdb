package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.ServiceType;
import com.rerec.fleetdb.repository.ServiceTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTypeService {

    private final ServiceTypeRepository serviceTypeRepository;

    public ServiceTypeService(ServiceTypeRepository serviceTypeRepository){
        this.serviceTypeRepository = serviceTypeRepository;
    }

    public List<ServiceType> getAllServiceType(){
        return serviceTypeRepository.findAll();
    }

    public void saveServiceType(ServiceType serviceType){
        serviceTypeRepository.save(serviceType);
    }

    public ServiceType getServiceTypeByID(Long id){
        Optional<ServiceType> optional =  serviceTypeRepository.findById(id);

        ServiceType serviceType = null;

        if(optional.isPresent()){
            serviceType = optional.get();
        } else {
            throw new RuntimeException(serviceType + " not found");
        }

        return serviceType;
    }

    public void deleteServiceType(Long id){
        this.serviceTypeRepository.deleteById(id);
    }

    public Page<ServiceType> findPaginated(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return this.serviceTypeRepository.findAll(pageable);
    }
}
