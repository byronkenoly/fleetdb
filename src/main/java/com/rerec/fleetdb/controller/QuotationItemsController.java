package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.QuotationItems;
import com.rerec.fleetdb.service.QuotationItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuotationItemsController {

    private final QuotationItemsService quotationItemsService;

    public QuotationItemsController(QuotationItemsService quotationItemsService){
        this.quotationItemsService = quotationItemsService;
    }

    @GetMapping("/alterQuotationItems/{no}")
    public String addQuotationItems(@PathVariable (value = "no") Long no, Model model){
        QuotationItems quotationItems = new QuotationItems();

        model.addAttribute("quotationItem", quotationItems);
        model.addAttribute("listOfChecklist", quotationItemsService.getAllChecklist());
        model.addAttribute("quotationFromDB", quotationItemsService.getQuotationByID(no));

        return "alterQuotationItems";
    }

    public String saveQuotationItem(@ModelAttribute("quotationItem") QuotationItems quotationItems){
        quotationItemsService.saveQuotationItem(quotationItems);
        return "redirect:/quotations";
    }
}
