package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Contractor;
import com.rerec.fleetdb.entities.Quotation;
import com.rerec.fleetdb.entities.Vehicle;
import com.rerec.fleetdb.repository.ContractorRepository;
import com.rerec.fleetdb.repository.QuotationRepository;
import com.rerec.fleetdb.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationService {

    private final QuotationRepository quotationRepository;

    private final VehicleRepository vehicleRepository;

    private final ContractorRepository contractorRepository;

    public QuotationService(QuotationRepository quotationRepository, VehicleRepository vehicleRepository, ContractorRepository contractorRepository){
        this.quotationRepository = quotationRepository;
        this.vehicleRepository = vehicleRepository;
        this.contractorRepository = contractorRepository;
    }

    public List<Quotation> getAllQuotation(){
        return quotationRepository.findAll();
    }

    public List<Vehicle> getAllVehicle(){
        return vehicleRepository.findAll();
    }

    public List<Contractor> getAllContractor(){
        return contractorRepository.findAll();
    }

    public void saveQuotation(Quotation quotation){
        quotationRepository.save(quotation);
    }
}
