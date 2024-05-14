package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.WorkInstructionItems;
import com.rerec.fleetdb.service.WorkInstructionItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WorkInstructionItemsController {

    private final WorkInstructionItemsService workInstructionItemsService;

    public WorkInstructionItemsController(WorkInstructionItemsService workInstructionItemsService) {
        this.workInstructionItemsService = workInstructionItemsService;
    }

    @GetMapping("/alterWorkInstructionItems/{no}")
    public String addWorkInstructionItems(@PathVariable(value = "no") Long no, Model model){
        WorkInstructionItems workInstructionItems = new WorkInstructionItems();

        model.addAttribute("workInstructionItem", workInstructionItems);
        model.addAttribute("listOfChecklist", workInstructionItemsService.getAllChecklist());
        model.addAttribute("workInstructionFromDB", workInstructionItemsService.getWorkInstructionByID(no));

        return "alterWorkInstructionItems";
    }

    @PostMapping("/saveWorkInstructionItems")
    public String saveWorkInstructionItems(@ModelAttribute("workInstructionItem") WorkInstructionItems workInstructionItems){
        workInstructionItemsService.saveWorkInstructionItem(workInstructionItems);
        return "redirect:/workInstructions";
    }
}
