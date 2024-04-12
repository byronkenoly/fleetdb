package com.rerec.fleetdb.entities;

import jakarta.persistence.*;

import java.util.Calendar;
@Entity
public class WorkInstruction {
    @Id
    @GeneratedValue
    private Long no;
    private String numberPlate;
    @Temporal(TemporalType.DATE)
    private Calendar date;

    @ManyToOne
    @JoinColumn(name="contractor_id")
    private Contractor contractor;

    @ManyToOne
    @JoinColumn(name="staff_id")
    private Staff staff;

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

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
