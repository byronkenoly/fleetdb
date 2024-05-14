package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.Make;
import com.rerec.fleetdb.entities.Region;
import com.rerec.fleetdb.service.RegionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegionController {

    private final RegionService regionService;

    public RegionController(RegionService regionService){
        this.regionService = regionService;
    }

    @GetMapping("/region")
    public String viewRegion(Model model){
        model.addAttribute("listOfRegion", regionService.getAllRegion());
        return "region";
    }

    @GetMapping("/newRegion")
    public String addNewRegion(Model model){
        Region region = new Region();
        model.addAttribute("region", region);
        return "newRegion";
    }

    @PostMapping("/saveRegion")
    public String saveRegion(@ModelAttribute("region") Region region){
        regionService.saveRegion(region);
        return "redirect:/region";
    }

    @GetMapping("/updateRegion/{id}")
    public String updateExistingRegion(@PathVariable(value = "id") Long id, Model model){
        Region region = regionService.getRegionByID(id);

        // set region as a model attribute to pre-populate the form
        model.addAttribute("region", region);

        return "updateRegion";
    }

    @GetMapping("/deleteRegion/{id}")
    public String deleteRegion(@PathVariable (value = "id") Long id){
        this.regionService.deleteRegion(id);
        return "redirect:/region";
    }
}
