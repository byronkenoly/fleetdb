package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.service.MileageSummaryService;
import org.springframework.stereotype.Controller;

@Controller
public class MileageSummaryController {

    private final MileageSummaryService mileageSummaryService;

    public MileageSummaryController(MileageSummaryService mileageSummaryService){
        this.mileageSummaryService = mileageSummaryService;
    }
}
