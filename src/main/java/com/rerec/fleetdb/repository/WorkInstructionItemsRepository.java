package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.WorkInstructionItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkInstructionItemsRepository extends JpaRepository<WorkInstructionItems, Long> {
}
