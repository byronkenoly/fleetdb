package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.Mileage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MileageRepository extends JpaRepository<Mileage, Long> {
}
