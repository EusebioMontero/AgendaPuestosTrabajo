package com.emc.apiContactos_01.repositories;

import com.emc.apiContactos_01.entities.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PuestosRepository extends JpaRepository<Puesto, Long> {

    List<Puesto> findByGuardia(boolean guardia);
}
