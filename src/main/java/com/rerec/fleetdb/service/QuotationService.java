package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Quotation;
import com.rerec.fleetdb.repository.QuotationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationService {

    private final QuotationRepository quotationRepository;

    public QuotationService(QuotationRepository quotationRepository){
        this.quotationRepository = quotationRepository;
    }

    public List<Quotation> getAllQuotation(){
        return quotationRepository.findAll();
    }

    public void saveQuotation(Quotation quotation){
        quotationRepository.save(quotation);
    }
}
