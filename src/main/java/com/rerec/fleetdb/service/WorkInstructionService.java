package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Contractor;
import com.rerec.fleetdb.entities.Staff;
import com.rerec.fleetdb.entities.Vehicle;
import com.rerec.fleetdb.entities.WorkInstruction;
import com.rerec.fleetdb.repository.ContractorRepository;
import com.rerec.fleetdb.repository.StaffRepository;
import com.rerec.fleetdb.repository.VehicleRepository;
import com.rerec.fleetdb.repository.WorkInstructionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkInstructionService {

    private final WorkInstructionRepository workInstructionRepository;

    private final VehicleRepository vehicleRepository;

    private final ContractorRepository contractorRepository;

    private final StaffRepository staffRepository;

    public WorkInstructionService(WorkInstructionRepository workInstructionRepository, VehicleRepository vehicleRepository, ContractorRepository contractorRepository, StaffRepository staffRepository){
        this.workInstructionRepository = workInstructionRepository;
        this.vehicleRepository = vehicleRepository;
        this.contractorRepository = contractorRepository;
        this.staffRepository = staffRepository;
    }

    public List<WorkInstruction> getAllWorkInstruction(){
        return workInstructionRepository.findAll();
    }

    public List<Vehicle> getAllVehicle(){
        return vehicleRepository.findAll();
    }

    public List<Contractor> getAllContractor() {
        return contractorRepository.findAll();
    }

    public List<Staff> getAllStaff(){
        return  staffRepository.findAll();
    }

    public WorkInstruction getWorkInstructionByID(Long id){
        Optional<WorkInstruction> optional = workInstructionRepository.findById(id);

        WorkInstruction workInstruction = null;

        if(optional.isPresent()){
            workInstruction = optional.get();
        } else {
            throw new RuntimeException(id + " not found");
        }

        return workInstruction;
    }

    public void saveWorkInstruction(WorkInstruction workInstruction){
        workInstructionRepository.save(workInstruction);
    }

    public void deleteWorkInstruction(Long no){
        this.workInstructionRepository.deleteById(no);
    }
}
