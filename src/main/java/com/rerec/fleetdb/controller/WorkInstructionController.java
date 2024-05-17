package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.WorkInstruction;
import com.rerec.fleetdb.service.WorkInstructionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WorkInstructionController {

    private final WorkInstructionService workInstructionService;

    public WorkInstructionController(WorkInstructionService workInstructionService){
        this.workInstructionService = workInstructionService;
    }

    @GetMapping("/workInstructions")
    public String viewWorkInstructions(Model model){
        List<WorkInstruction> workInstructions = workInstructionService.getAllWorkInstruction();

        model.addAttribute("listOfWorkInstructions", workInstructions);

        return "workInstructions";
    }

    @GetMapping("/newWorkInstruction")
    public String addNewWorkInstruction(Model model){
        WorkInstruction workInstruction = new WorkInstruction();

        model.addAttribute("workInstruction", workInstruction);
        model.addAttribute("listOfVehicle", workInstructionService.getAllVehicle());
        model.addAttribute("listOfContractor", workInstructionService.getAllContractor());
        model.addAttribute("listOfStaff", workInstructionService.getAllStaff());

        return "newWorkInstruction";
    }

    @PostMapping("/saveWorkInstruction")
    public String saveWorkInstruction(@ModelAttribute("workInstruction") WorkInstruction workInstruction){
        workInstructionService.saveWorkInstruction(workInstruction);
        return "redirect:/workInstructions";
    }

    @GetMapping("/updateWorkInstruction/{no}")
    public String updateExistingWorkInstruction(@PathVariable (value = "no") Long no, Model model){
        WorkInstruction workInstruction = workInstructionService.getWorkInstructionByID(no);

        //set work instruction as a model attribute to pre-populate the form
        model.addAttribute("workInstruction", workInstruction);
        model.addAttribute("listOfVehicle", workInstructionService.getAllVehicle());
        model.addAttribute("listOfContractor", workInstructionService.getAllContractor());
        model.addAttribute("listOfStaff", workInstructionService.getAllStaff());

        return "updateWorkInst";
    }

    @GetMapping("/deleteWorkInstruction/{no}")
    public String deleteWorkInstruction(@PathVariable (value = "no") Long no){
        this.workInstructionService.deleteWorkInstruction(no);
        return "redirect:/workInstructions";
    }
}
