package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.ServiceTracker;
import com.rerec.fleetdb.service.ServiceTrackerService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ServiceTrackerController {

    private final ServiceTrackerService serviceTrackerService;

    public ServiceTrackerController(ServiceTrackerService serviceTrackerService){
        this.serviceTrackerService = serviceTrackerService;
    }

    @GetMapping("/serviceTracker")
    public String viewServiceTracker(Model model){
        return findPaginated(1, model);
    }

    @GetMapping("/newServiceTracker")
    public String addNewServiceTracker(Model model){
        ServiceTracker serviceTracker = new ServiceTracker();

        model.addAttribute("serviceTracker", serviceTracker);
        model.addAttribute("listOfVehicle", serviceTrackerService.getAllVehicle());
        model.addAttribute("listOfServiceType", serviceTrackerService.getAllServiceType());

        return "newServiceTracker";
    }

    @PostMapping("/saveServiceTracker")
    public String saveServiceTracker(@ModelAttribute("serviceTracker") ServiceTracker serviceTracker){
        serviceTrackerService.saveServiceTracker(serviceTracker);
        return "redirect:/serviceTracker";
    }

    @GetMapping("/updateServiceTracker/{no}")
    public String updateExistingTracker(@PathVariable (value = "no") Long no, Model model){
        ServiceTracker serviceTracker = serviceTrackerService.getTrackerByID(no);

        model.addAttribute("serviceTracker", serviceTracker);
        model.addAttribute("listOfVehicle", serviceTrackerService.getAllVehicle());
        model.addAttribute("listOfServiceType", serviceTrackerService.getAllServiceType());

        return "updateTracker";
    }

    @GetMapping("/deleteTracker/{no}")
    public String deleteTracker(@PathVariable (value = "no") Long no){
        this.serviceTrackerService.deleteTracker(no);
        return "redirect:/serviceTracker";
    }

    @GetMapping("/trackerPage/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model){
        int pageSize = 10;

        Page<ServiceTracker> page = serviceTrackerService.findPaginated(pageNo, pageSize);
        List<ServiceTracker> listOfServiceTracker = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listOfServiceTracker", listOfServiceTracker);

        return "serviceTracker";
    }
}
