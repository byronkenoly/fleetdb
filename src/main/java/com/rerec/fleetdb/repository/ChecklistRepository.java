package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
}
