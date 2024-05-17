package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService){
        this.dataService = dataService;
    }

    @GetMapping("/api")
    public String showData(Model model){
        model.addAttribute("data", dataService.getCombinedData());
        return "repair";
    }
}
