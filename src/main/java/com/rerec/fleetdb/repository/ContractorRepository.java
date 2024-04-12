package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractorRepository extends JpaRepository<Contractor, Long> {
}
