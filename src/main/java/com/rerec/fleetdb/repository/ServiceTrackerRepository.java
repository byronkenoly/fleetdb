package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.ServiceTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceTrackerRepository extends JpaRepository<ServiceTracker, Long> {
    @Query("SELECT tracker.vehicle.numberPlate, tracker.serviceType.no, MAX(tracker.lastServiceDate) " +
            "FROM ServiceTracker tracker " +
            "GROUP BY tracker.vehicle.numberPlate, tracker.serviceType.no")
    List<Object[]> findLastServiceRecordByVehicleAndServiceType();
}
