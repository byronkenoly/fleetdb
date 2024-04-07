package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.Invoice;
import com.rerec.fleetdb.entities.Make;
import com.rerec.fleetdb.entities.Vehicle;
import com.rerec.fleetdb.service.MakeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MakeController {

    private final MakeService makeService;

    public MakeController(MakeService makeService){
        this.makeService = makeService;
    }

    @GetMapping("/make")
    public String viewMake(Model model){
        model.addAttribute("listOfMake", makeService.getAllMake());
        return "make";
    }

    @GetMapping("/newMake")
    public String addNewMake(Model model){
        Make make = new Make();
        model.addAttribute("make", make);
        return "newMake";
    }

    @PostMapping("/saveMake")
    public String saveMake(@ModelAttribute("make") Make make){
        makeService.saveMake(make);
        return "redirect:/make";
    }

    @GetMapping("/updateMake/{id}")
    public String updateExistingMake(@PathVariable(value = "id") Long id, Model model){
        Make make = makeService.getMakeByID(id);

        // set vehicle as a model attribute to pre-populate the form
        model.addAttribute("make", make);

        return "updateMake";
    }

    @GetMapping("/deleteMake/{id}")
    public String deleteMake(@PathVariable (value = "id") Long id){
        this.makeService.deleteMake(id);
        return "redirect:/make";
    }
}
