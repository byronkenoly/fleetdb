package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.service.QuotationService;
import org.springframework.stereotype.Controller;

@Controller
public class QuotationController {

    private final QuotationService quotationService;

    public QuotationController(QuotationService quotationService){
        this.quotationService = quotationService;
    }
}
