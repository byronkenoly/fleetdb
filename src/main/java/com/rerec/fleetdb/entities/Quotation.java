package com.rerec.fleetdb.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

@Entity
public class Quotation {
    @Id
    @GeneratedValue
    private Long no;

    @ManyToOne
    @JoinColumn(name = "vehicle_no_plate")
    private Vehicle vehicle;

    private String documentNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String serviceDescription;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
