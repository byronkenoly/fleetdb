package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.InvoiceItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItems, Long> {
}
