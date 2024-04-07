package com.rerec.fleetdb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vehicle {
    @Id
    private String numberPlate;
    private String region;
    private int engineCapacity;

    @ManyToOne
    @JoinColumn(name="make_id")
    private Make make;

    public String getNumberPlate(){
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate){
        this.numberPlate = numberPlate;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
}

