package com.rerec.fleetdb.entities;

import jakarta.persistence.*;

@Entity
public class QuotedWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="checklist_id")
    private Checklist checklist;

    @ManyToOne
    @JoinColumn(name="quotation_id")
    private Quotation quotation;
}
