package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.Invoice;
import com.rerec.fleetdb.entities.InvoiceItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
