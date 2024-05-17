package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Checklist;
import com.rerec.fleetdb.entities.Invoice;
import com.rerec.fleetdb.entities.InvoiceItems;
import com.rerec.fleetdb.repository.ChecklistRepository;
import com.rerec.fleetdb.repository.InvoiceItemsRepository;
import com.rerec.fleetdb.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceItemsService {

    private final InvoiceItemsRepository invoiceItemsRepository;

    private final ChecklistRepository checklistRepository;

    private final InvoiceRepository invoiceRepository;

    public InvoiceItemsService(InvoiceItemsRepository invoiceItemsRepository, ChecklistRepository checklistRepository, InvoiceRepository invoiceRepository){
        this.invoiceItemsRepository = invoiceItemsRepository;
        this.checklistRepository = checklistRepository;
        this.invoiceRepository = invoiceRepository;
    }

    public List<InvoiceItems> getAllInvoiceItems(){
        return invoiceItemsRepository.findAll();
    }

    public List<Checklist> getAllChecklist(){
        return checklistRepository.findAll();
    }

    public void saveInvoiceItem(InvoiceItems invoiceItems){
        invoiceItemsRepository.save(invoiceItems);
    }

    public Invoice getInvoiceByID(Long id){
        Optional<Invoice> optional = invoiceRepository.findById(id);

        Invoice invoice = null;

        if(optional.isPresent()){
            invoice = optional.get();
        } else {
            throw new RuntimeException(id + " not found");
        }

        return invoice;
    }
}
