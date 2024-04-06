package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.WorkInstruction;
import com.rerec.fleetdb.service.WorkInstructionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WorkInstructionController {

    private final WorkInstructionService workInstructionService;

    public WorkInstructionController(WorkInstructionService workInstructionService){
        this.workInstructionService = workInstructionService;
    }

    @GetMapping("/workInstructions")
    public String viewWorkInstructions(Model model){
        model.addAttribute("listOfWorkInstructions", workInstructionService.getAllWorkInstruction());
        return "workInstructions";
    }

    @GetMapping("/newWorkInstruction")
    public String addNewWorkInstruction(Model model){
        WorkInstruction workInstruction = new WorkInstruction();
        model.addAttribute("workInstruction", workInstruction);
        return "newWorkInstruction";
    }

    @PostMapping("/saveWorkInstruction")
    public String saveWorkInstruction(@ModelAttribute("workInstruction") WorkInstruction workInstruction){
        workInstructionService.saveWorkInstruction(workInstruction);
        return "redirect:/workInstructions";
    }
}
