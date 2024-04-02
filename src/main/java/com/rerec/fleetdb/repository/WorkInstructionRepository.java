package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.WorkInstruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkInstructionRepository extends JpaRepository<WorkInstruction, Long> {
}
