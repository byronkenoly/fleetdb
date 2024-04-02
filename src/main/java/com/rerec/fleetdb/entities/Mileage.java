package com.rerec.fleetdb.entities;

import jakarta.persistence.*;

import java.util.Calendar;

@Entity
public class Mileage {
    @Id
    @GeneratedValue
    private Long no;
    @Temporal(TemporalType.DATE)
    private Calendar startDate;

    @Temporal(TemporalType.DATE)
    private Calendar finalDate;

    private Float distanceCovered;

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Calendar finalDate) {
        this.finalDate = finalDate;
    }

    public Float getDistanceCovered() {
        return distanceCovered;
    }

    public void setDistanceCovered(Float distanceCovered) {
        this.distanceCovered = distanceCovered;
    }
}
