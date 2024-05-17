package com.rerec.fleetdb.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class WorkInstruction {
    @Id
    @GeneratedValue
    private Long no;

    @ManyToOne
    @JoinColumn(name = "vehicle_no_plate")
    private Vehicle vehicle;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @ManyToOne
    @JoinColumn(name="contractor_id")
    private Contractor contractor;

    @OneToMany(mappedBy = "workInstruction", cascade = CascadeType.ALL)
    private List<WorkInstructionItems> workInstructionItems = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="staff_id")
    private Staff staff;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public List<WorkInstructionItems> getWorkInstructionItems() {
        return workInstructionItems;
    }

    public void setWorkInstructionItems(List<WorkInstructionItems> workInstructionItems) {
        this.workInstructionItems = workInstructionItems;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
