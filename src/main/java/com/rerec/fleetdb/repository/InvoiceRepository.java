package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
