package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.Mileage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataRepository extends JpaRepository<Mileage, Long> {

    @Query("SELECT m.vehicle.numberPlate, " +
            "SUM(m.distanceCovered), " +
            "st.serviceType.type, " +
            "st.lastServiceMileage, " +
            "st.lastServiceDate " +
            "FROM Mileage m " +
            "LEFT JOIN ServiceTracker st ON m.vehicle.numberPlate = st.vehicle.numberPlate " +
            "WHERE (st.vehicle.numberPlate, st.serviceType.no, st.lastServiceDate) IN " +
            "(SELECT st2.vehicle.numberPlate, st2.serviceType.no, MAX(st2.lastServiceDate) " +
            "FROM ServiceTracker st2 " +
            "GROUP BY st2.vehicle.numberPlate, st2.serviceType.no) " +
            "GROUP BY m.vehicle.numberPlate, st.serviceType.type, st.lastServiceMileage, st.lastServiceDate")
    List<Object[]> findCombinedData();
}
