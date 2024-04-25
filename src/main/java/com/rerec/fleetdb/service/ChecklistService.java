package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Checklist;
import com.rerec.fleetdb.entities.Vehicle;
import com.rerec.fleetdb.repository.ChecklistRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChecklistService {

    private final ChecklistRepository checklistRepository;

    public ChecklistService(ChecklistRepository checklistRepository){
        this.checklistRepository = checklistRepository;
    }

    public List<Checklist> getAllChecklist(){
        return checklistRepository.findAll();
    }

    public void saveChecklistItem(Checklist checklist){
        checklistRepository.save(checklist);
    }

    public Checklist getItemById(Long id){
        Optional<Checklist> optional = checklistRepository.findById(id);

        Checklist checklist = null;

        if(optional.isPresent()){
            checklist = optional.get();
        } else {
            throw new RuntimeException(id + " not found");
        }

        return checklist;
    }

    public void deleteChecklistItem(Long id){
        this.checklistRepository.deleteById(id);
    }

    public Page<Checklist> paginateRecords(int pageNo, int pageSize){
        //Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.checklistRepository.findAll(pageable);
        //return this.vehicleRepository.findAll(sort);
    }
}
