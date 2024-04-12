package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.Invoice;
import com.rerec.fleetdb.entities.Make;
import com.rerec.fleetdb.entities.Vehicle;
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
public class MakeController {

    private final MakeService makeService;

    public MakeController(MakeService makeService){
        this.makeService = makeService;
    }

    @GetMapping("/make")
    public String viewMake(Model model){
        //model.addAttribute("listOfMake", makeService.getAllMake());
        //return "make";
        return findPaginated(1, model);
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

    @GetMapping("/makePage/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model){
        int pageSize = 10;

        Page<Make> page = makeService.findPaginated(pageNo, pageSize);
        List<Make> listOfMake = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listOfMake", listOfMake);

        return "make";
    }
}
