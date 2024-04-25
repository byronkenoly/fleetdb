package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.Invoice;
import com.rerec.fleetdb.entities.InvoiceItems;
import com.rerec.fleetdb.entities.Vehicle;
import com.rerec.fleetdb.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    public String viewInvoices(Model model){
        List<Invoice> invoice = invoiceService.getAllInvoice();

        model.addAttribute("listOfInvoices", invoice);
        /* model.addAttribute("invoiceItemsMap", invoiceService.getAllItemsByID(invoice)); */

        return "invoices";
    }

    @GetMapping("/newInvoice")
    public String addNewInvoice(Model model){
        Invoice invoice = new Invoice();

        model.addAttribute("invoice", invoice);
        model.addAttribute("listOfVehicle", invoiceService.getAllVehicle());

        return "newInvoice";
    }

    @PostMapping("/saveInvoice")
    public String saveInvoice(@ModelAttribute("invoice") Invoice invoice){
        invoiceService.saveInvoice(invoice);
        return "redirect:/invoices";
    }
}
