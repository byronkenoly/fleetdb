package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.Invoice;
import com.rerec.fleetdb.entities.Quotation;
import com.rerec.fleetdb.service.QuotationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuotationController {

    private final QuotationService quotationService;

    public QuotationController(QuotationService quotationService){
        this.quotationService = quotationService;
    }

    @GetMapping("/quotations")
    public String viewQuotations(Model model){
        model.addAttribute("listOfQuotations", quotationService.getAllQuotation());
        return "quotations";
    }

    @GetMapping("/newQuotation")
    public String addNewQuotation(Model model){
        Quotation quotation = new Quotation();
        model.addAttribute("quotation", quotation);
        return "newQuotation";
    }

    @PostMapping("/saveQuotation")
    public String saveQuotation(@ModelAttribute("quotation") Quotation quotation){
        quotationService.saveQuotation(quotation);
        return "redirect:/quotations";
    }
}
