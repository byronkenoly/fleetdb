package com.rerec.fleetdb.entities;

import jakarta.persistence.*;

import java.util.Calendar;

@Entity
public class Quotation {
    @Id
    @GeneratedValue
    private Long no;
    private String numberPlate;
    private long documentNo;
    @Temporal(TemporalType.DATE)
    private Calendar date;
    private String serviceDescription;
    private Float total;

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public long getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(long documentNo) {
        this.documentNo = documentNo;
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
}
