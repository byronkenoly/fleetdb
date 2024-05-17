package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.Checklist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChecklistRepository extends JpaRepository<Checklist, Long> {

    @Query("SELECT c FROM Checklist c WHERE c.item LIKE %?1%")
    public Page<Checklist> findAll(String keyword, Pageable pageable);
}
