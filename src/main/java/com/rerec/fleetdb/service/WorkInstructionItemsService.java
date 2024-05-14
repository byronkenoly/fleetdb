package com.rerec.fleetdb.service;

import com.rerec.fleetdb.entities.Checklist;
import com.rerec.fleetdb.entities.WorkInstruction;
import com.rerec.fleetdb.entities.WorkInstructionItems;
import com.rerec.fleetdb.repository.ChecklistRepository;
import com.rerec.fleetdb.repository.WorkInstructionItemsRepository;
import com.rerec.fleetdb.repository.WorkInstructionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkInstructionItemsService {

    private final WorkInstructionItemsRepository workInstructionItemsRepository;

    private final ChecklistRepository checklistRepository;

    private final WorkInstructionRepository workInstructionRepository;

    public WorkInstructionItemsService(WorkInstructionItemsRepository workInstructionItemsRepository, ChecklistRepository checklistRepository, WorkInstructionRepository workInstructionRepository){
        this.workInstructionItemsRepository = workInstructionItemsRepository;
        this.checklistRepository = checklistRepository;
        this.workInstructionRepository = workInstructionRepository;
    }

    public List<WorkInstructionItems> getAllWorkInstructionItems(){
        return workInstructionItemsRepository.findAll();
    }

    public List<Checklist> getAllChecklist(){
        return checklistRepository.findAll();
    }

    public void saveWorkInstructionItem(WorkInstructionItems workInstructionItems){
        workInstructionItemsRepository.save(workInstructionItems);
    }

    public WorkInstruction getWorkInstructionByID(Long id){
        Optional<WorkInstruction> optional = workInstructionRepository.findById(id);

        WorkInstruction workInstruction = null;

        if(optional.isPresent()){
            workInstruction = optional.get();
        } else {
            throw new RuntimeException(id + " not found");
        }

        return workInstruction;
    }
}
