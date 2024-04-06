package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.Vehicle;
import com.rerec.fleetdb.service.VehicleService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public String viewVehicles(Model model){
        //model.addAttribute("listOfVehicles", vehicleService.getAllVehicle());
        return findPaginated(1, model);
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

    @GetMapping("/updateVehicle/{numberPlate}")
    public String updateExistingVehicle(@PathVariable (value = "numberPlate") String numberPlate, Model model){
        Vehicle vehicle = vehicleService.getVehicleByNumberPlate(numberPlate);

        // set vehicle as a model attribute to pre-populate the form
        model.addAttribute("vehicle", vehicle);

        return "updateVehicle";
    }

    @GetMapping("/deleteVehicle/{numberPlate}")
    public String deleteVehicle(@PathVariable (value = "numberPlate") String numberPlate){
        this.vehicleService.deleteVehicle(numberPlate);
        return "redirect:/vehicles";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model){
        //Iterable<Vehicle> sorted = vehicleService.sortRecords(sortField, sortDir);
        //List<Vehicle> listOfVehicles = sorted.getContent()
        int pageSize = 5;

        Page<Vehicle> page = vehicleService.paginateRecords(pageNo, pageSize);
        List<Vehicle> listOfVehicles = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listOfVehicles", listOfVehicles);

        return "vehicles";
    }
}