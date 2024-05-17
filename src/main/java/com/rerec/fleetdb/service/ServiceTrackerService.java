package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.ServiceTracker;
import com.rerec.fleetdb.entities.ServiceType;
import com.rerec.fleetdb.entities.Vehicle;
import com.rerec.fleetdb.repository.ServiceTrackerRepository;
import com.rerec.fleetdb.repository.ServiceTypeRepository;
import com.rerec.fleetdb.repository.VehicleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTrackerService {

    private final ServiceTrackerRepository serviceTrackerRepository;

    private final VehicleRepository vehicleRepository;

    private final ServiceTypeRepository serviceTypeRepository;

    public ServiceTrackerService(ServiceTrackerRepository serviceTrackerRepository, VehicleRepository vehicleRepository, ServiceTypeRepository serviceTypeRepository){
        this.serviceTrackerRepository = serviceTrackerRepository;
        this.vehicleRepository = vehicleRepository;
        this.serviceTypeRepository = serviceTypeRepository;
    }

    public List<ServiceTracker> getAllServiceTracking(){
        return serviceTrackerRepository.findAll();
    }

    public List<Vehicle> getAllVehicle(){
        return vehicleRepository.findAll();
    }

    public List<ServiceType> getAllServiceType(){
        return serviceTypeRepository.findAll();
    }

    public ServiceTracker getTrackerByID(Long id){
        Optional<ServiceTracker> optional = serviceTrackerRepository.findById(id);

        ServiceTracker serviceTracker = null;

        if(optional.isPresent()){
            serviceTracker = optional.get();
        } else {
            throw new RuntimeException(id + " not found");
        }

        return serviceTracker;
    }

    public void saveServiceTracker(ServiceTracker serviceTracker){
        serviceTrackerRepository.save(serviceTracker);
    }

    public void deleteTracker(Long no){
        this.serviceTrackerRepository.deleteById(no);
    }

    public Page<ServiceTracker> findPaginated(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return this.serviceTrackerRepository.findAll(pageable);
    }
}
