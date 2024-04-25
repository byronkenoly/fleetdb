package com.rerec.fleetdb.entities;

import jakarta.persistence.*;

@Entity
public class InvoiceItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="checklist_id")
    private Checklist checklist;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="invoice_id")
    private Invoice invoice;

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

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
