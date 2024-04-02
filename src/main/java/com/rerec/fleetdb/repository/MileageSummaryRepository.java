package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.MileageSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MileageSummaryRepository extends JpaRepository<MileageSummary, String> {
}
