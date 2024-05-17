package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.InvoiceItems;
import com.rerec.fleetdb.service.InvoiceItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InvoiceItemsController {

    private final InvoiceItemsService invoiceItemsService;

    public InvoiceItemsController(InvoiceItemsService invoiceItemsService){
        this.invoiceItemsService = invoiceItemsService;
    }

    @GetMapping("/alterInvoiceItems/{no}")
    public String addInvoiceItems(@PathVariable (value = "no") Long no, Model model){
        InvoiceItems invoiceItems = new InvoiceItems();

        model.addAttribute("invoiceItem", invoiceItems);
        model.addAttribute("listOfChecklist", invoiceItemsService.getAllChecklist());
        model.addAttribute("invoiceFromDB", invoiceItemsService.getInvoiceByID(no));

        return "alterInvoiceItems";
    }

    @PostMapping("/saveInvoiceItems")
    public String saveInvoiceItem(@ModelAttribute("invoiceItem") InvoiceItems invoiceItems){
        invoiceItemsService.saveInvoiceItem(invoiceItems);
        return "redirect:/invoices";
    }
}
