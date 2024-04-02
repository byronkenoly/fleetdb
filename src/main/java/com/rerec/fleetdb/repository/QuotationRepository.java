package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotationRepository extends JpaRepository<Quotation, Long> {
}
