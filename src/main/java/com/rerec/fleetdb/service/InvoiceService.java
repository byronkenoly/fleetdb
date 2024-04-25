package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Invoice;
import com.rerec.fleetdb.entities.InvoiceItems;
import com.rerec.fleetdb.entities.Vehicle;
import com.rerec.fleetdb.repository.InvoiceItemsRepository;
import com.rerec.fleetdb.repository.InvoiceRepository;
import com.rerec.fleetdb.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    private final VehicleRepository vehicleRepository;

    public InvoiceService(InvoiceRepository invoiceRepository, VehicleRepository vehicleRepository){
        this.invoiceRepository = invoiceRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public List<Invoice> getAllInvoice(){
        return invoiceRepository.findAll();
    }

    public List<Vehicle> getAllVehicle(){
        return vehicleRepository.findAll();
    }

    /*
    public Map<Long, List<InvoiceItems>> getAllItemsByID(List<Invoice> invoices) {
        Map<Long, List<InvoiceItems>> invoiceItemsMap = new HashMap<>();

        for(Invoice invoice : invoices){
            List<InvoiceItems> invoiceItems = invoiceRepository.findItemsByNo(invoice.getNo());
            invoiceItemsMap.put(invoice.getNo(), invoiceItems);
        }

        return invoiceItemsMap;
    }*/

    /*
    public List<InvoiceItems> getItemsByInvoice(Invoice invoice){
        return invoiceRepository.findItemsByInvoice(invoice);
    }*/

    public void saveInvoice(Invoice invoice){

        invoiceRepository.save(invoice);
    }
}
