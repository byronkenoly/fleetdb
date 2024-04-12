package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepository extends JpaRepository<Designation, Long> {
}
