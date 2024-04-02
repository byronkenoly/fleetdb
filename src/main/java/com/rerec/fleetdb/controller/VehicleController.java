package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.Vehicle;
import com.rerec.fleetdb.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public String viewVehicles(Model model){
        model.addAttribute("listOfVehicles", vehicleService.getAllVehicle());
        return "vehicles";
    }

    @GetMapping("/newVehicle")
    public String addNewVehicle(Model model){
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);
        return "newVehicle";
    }

    @PostMapping("/saveVehicle")
    public String saveVehicle(@ModelAttribute("vehicle") Vehicle vehicle){
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicles";
    }
}
