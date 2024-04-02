package com.rerec.fleetdb.service;

import com.rerec.fleetdb.repository.WorkInstructionRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkInstructionService {

    private final WorkInstructionRepository workInstructionRepository;

    public WorkInstructionService(WorkInstructionRepository workInstructionRepository){
        this.workInstructionRepository = workInstructionRepository;
    }
}
