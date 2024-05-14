package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}
