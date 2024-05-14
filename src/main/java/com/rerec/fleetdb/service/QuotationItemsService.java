package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Checklist;
import com.rerec.fleetdb.entities.Quotation;
import com.rerec.fleetdb.entities.QuotationItems;
import com.rerec.fleetdb.repository.ChecklistRepository;
import com.rerec.fleetdb.repository.QuotationItemsRepository;
import com.rerec.fleetdb.repository.QuotationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuotationItemsService {

    private final QuotationItemsRepository quotationItemsRepository;

    private final ChecklistRepository checklistRepository;

    private final QuotationRepository quotationRepository;

    public QuotationItemsService(QuotationItemsRepository quotationItemsRepository, ChecklistRepository checklistRepository, QuotationRepository quotationRepository){
        this.quotationItemsRepository = quotationItemsRepository;
        this.checklistRepository = checklistRepository;
        this.quotationRepository = quotationRepository;
    }

    public List<QuotationItems> getAllQuotationItems(){
        return quotationItemsRepository.findAll();
    }

    public List<Checklist> getAllChecklist(){
        return checklistRepository.findAll();
    }

    public void saveQuotationItem(QuotationItems quotationItems){
        quotationItemsRepository.save(quotationItems);
    }

    public Quotation getQuotationByID(Long id){
        Optional<Quotation> optional = quotationRepository.findById(id);

        Quotation quotation = null;

        if(optional.isPresent()){
            quotation = optional.get();
        } else {
            throw new RuntimeException(id + " not found");
        }

        return quotation;
    }
}
