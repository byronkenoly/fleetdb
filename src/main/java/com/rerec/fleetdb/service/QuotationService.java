package com.rerec.fleetdb.service;

import com.rerec.fleetdb.repository.QuotationRepository;
import org.springframework.stereotype.Service;

@Service
public class QuotationService {

    private final QuotationRepository quotationRepository;

    public QuotationService(QuotationRepository quotationRepository){
        this.quotationRepository = quotationRepository;
    }
}
