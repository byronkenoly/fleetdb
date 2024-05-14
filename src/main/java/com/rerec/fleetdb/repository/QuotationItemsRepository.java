package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.QuotationItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotationItemsRepository extends JpaRepository<QuotationItems, Long> {
}
