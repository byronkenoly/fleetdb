package com.rerec.fleetdb.controller;

import com.rerec.fleetdb.entities.Checklist;
import com.rerec.fleetdb.service.ChecklistService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ChecklistController {

    private final ChecklistService checklistService;

    public ChecklistController(ChecklistService checklistService){
        this.checklistService = checklistService;
    }

    @GetMapping("/checklist")
    public String viewChecklist(Model model){
        return findPaginated(1, model);
    }

    @GetMapping("/newChecklistItem")
    public String addNewItem(Model model){
        Checklist checklist = new Checklist();

        model.addAttribute("checklist", checklist);

        return "newChecklistItem";
    }

    @PostMapping("/saveChecklistItem")
    public String saveChecklistItem(@ModelAttribute("checklist") Checklist checklist){
        checklistService.saveChecklistItem(checklist);
        return "redirect:/checklist";
    }

    @GetMapping("/updateChecklistItem/{id}")
    public String updateExistingItem(@PathVariable (value = "id") Long id, Model model){
        Checklist checklist = checklistService.getItemById(id);

        // set vehicle as a model attribute to pre-populate the form
        model.addAttribute("checklist", checklist);

        return "updateChecklistItem";
    }

    @GetMapping("/deleteChecklistItem/{id}")
    public String deleteChecklistItem(@PathVariable (value = "id") Long id){
        this.checklistService.deleteChecklistItem(id);
        return "redirect:/checklist";
    }

    @GetMapping("/checklistPage/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model){
        int pageSize = 20;

        Page<Checklist> page = checklistService.paginateRecords(pageNo, pageSize);
        List<Checklist> listOfChecklist = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listOfChecklist", listOfChecklist);

        return "checklist";
    }

}
