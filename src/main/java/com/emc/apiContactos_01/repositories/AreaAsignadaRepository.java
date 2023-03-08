package com.emc.apiContactos_01.repositories;

import com.emc.apiContactos_01.entities.AreaAsignada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaAsignadaRepository extends JpaRepository<AreaAsignada, Long> {
}