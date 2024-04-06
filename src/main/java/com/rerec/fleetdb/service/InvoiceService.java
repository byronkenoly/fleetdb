package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Invoice;
import com.rerec.fleetdb.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getAllInvoice(){
        return invoiceRepository.findAll();
    }

    public void saveInvoice(Invoice invoice){
        invoiceRepository.save(invoice);
    }
}
