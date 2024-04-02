package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.service.MileageService;
import org.springframework.stereotype.Controller;

@Controller
public class MileageController {

    private final MileageService mileageService;

    public MileageController(MileageService mileageService){
        this.mileageService = mileageService;
    }
}
