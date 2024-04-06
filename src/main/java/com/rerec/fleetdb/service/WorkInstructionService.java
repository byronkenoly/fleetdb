package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.WorkInstruction;
import com.rerec.fleetdb.repository.WorkInstructionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkInstructionService {

    private final WorkInstructionRepository workInstructionRepository;

    public WorkInstructionService(WorkInstructionRepository workInstructionRepository){
        this.workInstructionRepository = workInstructionRepository;
    }

    public List<WorkInstruction> getAllWorkInstruction(){
        return workInstructionRepository.findAll();
    }

    public void saveWorkInstruction(WorkInstruction workInstruction){
        workInstructionRepository.save(workInstruction);
    }
}
