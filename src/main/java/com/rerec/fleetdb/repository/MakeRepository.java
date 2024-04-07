package com.rerec.fleetdb.repository;

import com.rerec.fleetdb.entities.Make;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakeRepository extends JpaRepository<Make, Long> {
}
