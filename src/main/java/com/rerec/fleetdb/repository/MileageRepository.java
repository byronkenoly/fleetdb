package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.Mileage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MileageRepository extends JpaRepository<Mileage, Long> {
    @Query("SELECT m.vehicle.numberPlate, SUM(m.distanceCovered) " +
            "FROM Mileage m " +
            "GROUP BY m.vehicle.numberPlate")
    List<Object[]> findTotalDistanceCoveredByVehicle();
}
