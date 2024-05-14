package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.ServiceType;
import com.rerec.fleetdb.service.ServiceTypeService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ServiceTypeController {

    private final ServiceTypeService serviceTypeService;

    public ServiceTypeController(ServiceTypeService serviceTypeService){
        this.serviceTypeService = serviceTypeService;
    }

    @GetMapping("/service")
    public String viewServiceType(Model model){
        return findPaginated(1, model);
    }

    @GetMapping("/newService")
    public String addNewService(Model model){
        ServiceType serviceType = new ServiceType();
        model.addAttribute("serviceType", serviceType);
        return "newService";
    }

    @PostMapping("/saveService")
    public String saveService(@ModelAttribute("service") ServiceType serviceType){
        serviceTypeService.saveServiceType(serviceType);
        return "redirect:/service";
    }

    @PostMapping("/updateService/{id}")
    public String updateExistingService(@PathVariable(value = "id") Long id, Model model){
        ServiceType serviceType = serviceTypeService.getServiceTypeByID(id);

        model.addAttribute("serviceType", serviceType);

        return "updateService";
    }

    @GetMapping("/deleteService/{id}")
    public String deleteService(@PathVariable (value = "id") Long id){
        this.serviceTypeService.deleteServiceType(id);
        return "redirect:/service";
    }

    @GetMapping("/servicePage/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model){
        int pageSize = 10;

        Page<ServiceType> page = serviceTypeService.findPaginated(pageNo, pageSize);
        List<ServiceType> listOfService = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listOfService", listOfService);

        return "service";
    }
}
