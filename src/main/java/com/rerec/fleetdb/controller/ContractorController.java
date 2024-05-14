package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.Contractor;
import com.rerec.fleetdb.entities.Invoice;
import com.rerec.fleetdb.entities.Make;
import com.rerec.fleetdb.entities.Vehicle;
import com.rerec.fleetdb.service.ContractorService;
import com.rerec.fleetdb.service.MakeService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContractorController {

    private final ContractorService contractorService;

    public ContractorController(ContractorService contractorService){
        this.contractorService = contractorService;
    }

    @GetMapping("/contractor")
    public String viewContractor(Model model){
        model.addAttribute("listOfContractor", contractorService.getAllContractor());
        return "contractor";
    }

    @GetMapping("/newContractor")
    public String addNewContractor(Model model){
        Contractor contractor = new Contractor();
        model.addAttribute("contractor", contractor);
        return "newContractor";
    }

    @PostMapping("/saveContractor")
    public String saveContractor(@ModelAttribute("contractor") Contractor contractor){
        contractorService.saveContractor(contractor);
        return "redirect:/contractor";
    }

    @GetMapping("/updateContractor/{id}")
    public String updateExistingContractor(@PathVariable(value = "id") Long id, Model model){
        Contractor contractor = contractorService.getContractorByID(id);

        // set contractor as a model attribute to pre-populate the form
        model.addAttribute("contractor", contractor);

        return "updateContractor";
    }

    @GetMapping("/deleteContractor/{id}")
    public String deleteContractor(@PathVariable (value = "id") Long id){
        this.contractorService.deleteContractor(id);
        return "redirect:/make";
    }
}