package com.emc.apiContactos_01.repositories;

import com.emc.apiContactos_01.entities.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonasRepository extends JpaRepository<Zona, Long> {
}
