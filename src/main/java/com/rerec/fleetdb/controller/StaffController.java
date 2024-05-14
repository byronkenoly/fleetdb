package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.Staff;
import com.rerec.fleetdb.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService){
        this.staffService = staffService;
    }

    @GetMapping("/staff")
    public String viewStaff(Model model){
        model.addAttribute("listOfStaff", staffService.getAllStaff());
        return "staff";
    }

    @GetMapping("/newStaff")
    public String addNewStaff(Model model){
        Staff staff = new Staff();

        model.addAttribute("staff", staff);
        model.addAttribute("listOfDesignation", staffService.getAllDesignation());

        return "newStaff";
    }

    @PostMapping("/saveStaff")
    public String saveStaff(@ModelAttribute("staff") Staff staff){
        staffService.saveStaff(staff);
        return "redirect:/staff";
    }

    @GetMapping("/updateStaff/{id}")
    public String updateExistingStaff(@PathVariable(value = "id") Long id, Model model){
        Staff staff = staffService.getStaffByID(id);

        // set staff as a model attribute to pre-populate the form
        model.addAttribute("staff", staff);
        model.addAttribute("listOfDesignation", staffService.getAllDesignation());

        return "updateStaff";
    }

    @GetMapping("/deleteStaff/{id}")
    public String deleteStaff(@PathVariable (value = "id") Long id){
        this.staffService.deleteStaff(id);
        return "redirect:/staff";
    }
}
