package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
