package com.rerec.fleetdb.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Quotation {
    @Id
    @GeneratedValue
    private Long no;

    @ManyToOne
    @JoinColumn(name = "vehicle_no_plate")
    private Vehicle vehicle;

    private String documentNo;

    @ManyToOne
    @JoinColumn(name="contractor_id")
    private Contractor contractor;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @OneToMany(mappedBy = "quotation")
    private List<QuotationItems> quotationItems = new ArrayList<>();

    private Float total;

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
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

    public List<QuotationItems> getQuotationItems() {
        return quotationItems;
    }

    public void setQuotationItems(List<QuotationItems> quotationItems) {
        this.quotationItems = quotationItems;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
