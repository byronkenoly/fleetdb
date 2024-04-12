package com.rerec.fleetdb.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Invoice {
    @Id
    @GeneratedValue
    private Long no;
    @ManyToOne
    @JoinColumn(name = "vehicle_no_plate")
    private Vehicle vehicle;
    private Long invoiceNo;
    @Temporal(TemporalType.DATE)
    private Calendar date;
    private String serviceDescription;
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

    public long getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(Long invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
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

