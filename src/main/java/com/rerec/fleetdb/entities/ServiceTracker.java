package com.rerec.fleetdb.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class ServiceTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @ManyToOne
    @JoinColumn(name="vehicle_no_plate")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name="service_type_id")
    private ServiceType serviceType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastServiceDate;

    private Float lastServiceMileage;

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

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public Float getLastServiceMileage() {
        return lastServiceMileage;
    }

    public void setLastServiceMileage(Float lastServiceMileage) {
        this.lastServiceMileage = lastServiceMileage;
    }
}
