package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.Mileage;
import com.rerec.fleetdb.service.MileageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MileageController {

    private final MileageService mileageService;

    public MileageController(MileageService mileageService){
        this.mileageService = mileageService;
    }

    @GetMapping("/mileage")
    public String viewMileage(Model model){

        model.addAttribute("listOfMileages", mileageService.getAllMileage());
        return "mileages";
    }

    @GetMapping("/newMileage")
    public String addNewMileage(Model model){
        Mileage mileage = new Mileage();

        model.addAttribute("mileage", mileage);
        model.addAttribute("listOfVehicle", mileageService.getAllVehicle());

        return "newMileage";
    }

    @PostMapping("/saveMileage")
    public String saveMileage(@ModelAttribute("mileage") Mileage mileage){
        mileageService.saveMileage(mileage);
        return "redirect:/mileage";
    }

    @GetMapping("/updateMileage/{no}")
    public String updateExistingMileage(@PathVariable (value = "no") Long no, Model model){
        Mileage mileage = mileageService.getMileageByID(no);

        model.addAttribute("mileage", mileage);
        model.addAttribute("listOfVehicle", mileageService.getAllVehicle());

        return "updateMileage";
    }

    @GetMapping("/deleteMileage/{no}")
    public String deleteMileage(@PathVariable (value = "no") Long no){
        this.mileageService.deleteMileage(no);
        return "redirect:/mileage";
    }
}
