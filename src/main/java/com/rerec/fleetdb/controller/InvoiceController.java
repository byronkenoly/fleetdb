package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.Invoice;
import com.rerec.fleetdb.entities.Vehicle;
import com.rerec.fleetdb.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    public String viewInvoices(Model model){
        model.addAttribute("listOfInvoices", invoiceService.getAllInvoice());
        return "invoices";
    }

    @GetMapping("/newInvoice")
    public String addNewInvoice(Model model){
        Invoice invoice = new Invoice();
        model.addAttribute("invoice", invoice);
        return "newInvoice";
    }

    @PostMapping("/saveInvoice")
    public String saveInvoice(@ModelAttribute("invoice") Invoice invoice){
        invoiceService.saveInvoice(invoice);
        return "redirect:/invoices";
    }
}
