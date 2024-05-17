package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Contractor;
import com.rerec.fleetdb.entities.Invoice;
import com.rerec.fleetdb.entities.Vehicle;
import com.rerec.fleetdb.repository.ContractorRepository;
import com.rerec.fleetdb.repository.InvoiceRepository;
import com.rerec.fleetdb.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    private final VehicleRepository vehicleRepository;

    private final ContractorRepository contractorRepository;

    public InvoiceService(InvoiceRepository invoiceRepository, VehicleRepository vehicleRepository, ContractorRepository contractorRepository){
        this.invoiceRepository = invoiceRepository;
        this.vehicleRepository = vehicleRepository;
        this.contractorRepository = contractorRepository;
    }

    public List<Invoice> getAllInvoice(){
        return invoiceRepository.findAll();
    }

    public List<Vehicle> getAllVehicle(){
        return vehicleRepository.findAll();
    }

    public List<Contractor> getAllContractor() {
        return contractorRepository.findAll();
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

    public void saveInvoice(Invoice invoice){

        invoiceRepository.save(invoice);
    }

    public void deleteInvoice(Long no){
        this.invoiceRepository.deleteById(no);
    }
}
