package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.Designation;
import com.rerec.fleetdb.entities.Make;
import com.rerec.fleetdb.service.DesignationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DesignationController {

    private final DesignationService designationService;

    public DesignationController(DesignationService designationService){
        this.designationService = designationService;
    }

    @GetMapping("/designation")
    public String viewDesignation(Model model){
        model.addAttribute("listOfDesignation", designationService.getAllDesignation());
        return "designation";
    }

    @GetMapping("/newDesignation")
    public String addNewDesignation(Model model){
        Designation designation = new Designation();
        model.addAttribute("designation", designation);
        return "newDesignation";
    }

    @PostMapping("/saveDesignation")
    public String saveDesignation(@ModelAttribute("designation") Designation designation){
        designationService.saveDesignation(designation);
        return "redirect:/designation";
    }

    @GetMapping("/updateDesignation/{id}")
    public String updateExistingDesignation(@PathVariable(value = "id") Long id, Model model){
        Designation designation = designationService.getDesignationByID(id);

        // set designation as a model attribute to pre-populate the form
        model.addAttribute("designation", designation);

        return "updateDesignation";
    }

    @GetMapping("/deleteDesignation/{id}")
    public String deleteDesignation(@PathVariable (value = "id") Long id){
        this.designationService.deleteDesignation(id);
        return "redirect:/designation";
    }
}
