package com.rerec.fleetdb.entities;

import jakarta.persistence.*;

@Entity
public class WorkInstructionItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="checklist_id")
    private Checklist checklist;

    @ManyToOne
    @JoinColumn(name="workInstruction_id")
    private WorkInstruction workInstruction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Checklist getChecklist() {
        return checklist;
    }

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }

    public WorkInstruction getWorkInstruction() {
        return workInstruction;
    }

    public void setWorkInstruction(WorkInstruction workInstruction) {
        this.workInstruction = workInstruction;
    }
}
