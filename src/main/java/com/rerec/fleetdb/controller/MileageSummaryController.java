package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.Mileage;
import com.rerec.fleetdb.entities.MileageSummary;
import com.rerec.fleetdb.service.MileageSummaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MileageSummaryController {

    private final MileageSummaryService mileageSummaryService;

    public MileageSummaryController(MileageSummaryService mileageSummaryService){
        this.mileageSummaryService = mileageSummaryService;
    }

    @GetMapping("/mileageSummary")
    public String viewMileageSummary(Model model){
        model.addAttribute("listOfMileageSummary", mileageSummaryService.getAllMileageSummary());
        return "mileageSummary";
    }
}
