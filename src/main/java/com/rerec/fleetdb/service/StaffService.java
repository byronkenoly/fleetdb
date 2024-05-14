package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Designation;
import com.rerec.fleetdb.entities.Staff;
import com.rerec.fleetdb.repository.DesignationRepository;
import com.rerec.fleetdb.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    private final StaffRepository staffRepository;
    private final DesignationRepository designationRepository;

    public StaffService(StaffRepository staffRepository, DesignationRepository designationRepository){
        this.staffRepository = staffRepository;
        this.designationRepository = designationRepository;
    }

    public List<Staff> getAllStaff(){
        return staffRepository.findAll();
    }

    public List<Designation> getAllDesignation(){
        return designationRepository.findAll();
    }

    public void saveStaff(Staff staff){
        staffRepository.save(staff);
    }

    public Staff getStaffByID(Long id){
        Optional<Staff> optional = staffRepository.findById(id);

        Staff staff = null;

        if(optional.isPresent()){
            staff = optional.get();
        } else {
            throw new RuntimeException(staff + " not found");
        }

        return staff;
    }

    public void deleteStaff(Long id){
        this.staffRepository.deleteById(id);
    }
}
