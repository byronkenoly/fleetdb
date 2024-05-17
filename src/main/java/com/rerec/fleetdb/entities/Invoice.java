package com.rerec.fleetdb.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @ManyToOne
    @JoinColumn(name = "vehicle_no_plate")
    private Vehicle vehicle;

    private String invoiceNo;

    @ManyToOne
    @JoinColumn(name="contractor_id")
    private Contractor contractor;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceItems> invoiceItems = new ArrayList<>();

    private Float total;
    //@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    //private List<InvoicedWork> invoicedWorks = new ArrayList<>();

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<InvoiceItems> getInvoiceItems(){
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItems> invoiceItems){
        this.invoiceItems = invoiceItems;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    /*
    public List<InvoicedWork> getInvoicedWorks() {
        return invoicedWorks;
    }

    public void setInvoicedWorks(List<InvoicedWork> invoicedWorks) {
        this.invoicedWorks = invoicedWorks;
    }*/
}

