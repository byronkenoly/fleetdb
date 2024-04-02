package com.rerec.fleetdb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MileageSummary {
    @Id
    private String numberPlate;
    private Float distanceCovered;

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Float getDistanceCovered() {
        return distanceCovered;
    }

    public void setDistanceCovered(Float distanceCovered) {
        this.distanceCovered = distanceCovered;
    }
}
