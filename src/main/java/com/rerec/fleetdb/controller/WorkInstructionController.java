package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.service.WorkInstructionService;
import org.springframework.stereotype.Controller;

@Controller
public class WorkInstructionController {

    private final WorkInstructionService workInstructionService;

    public WorkInstructionController(WorkInstructionService workInstructionService){
        this.workInstructionService = workInstructionService;
    }
}
