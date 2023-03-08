package com.emc.apiContactos_01.repositories;

import com.emc.apiContactos_01.entities.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactosRepository extends JpaRepository<Contacto, Long> {
        public List<Contacto> findByPuestoId(Long id);

//    @Query(value = """
//    SELECT C
//            FROM contactos C , puestos P
//            WHERE (C.id =  P. ) and P.guardia=:guardia
//            """,
//            nativeQuery = true)
//    List<Contacto> contactosByGuardia(@Param("guardia") boolean guardia);
//
//    @Query(value = """
//            SELECT C.id, C.apellido_1, C.apellido_2 , C.mail, C.nombre, c.tel_corp, C.tel_part
//            FROM contactos C , puestos  P, puestos_contacto PC, sedes S
//            WHERE (C.id=PC.contacto_id AND
//                PC.puestos_id = P.id AND
//                P.area_asignada_id = S.area_asignada_id)
//                AND S.nombre = :sede
//            """,
//            nativeQuery = true)
//    List<Contacto> contactosBySede(@Param("sede") String sede);
}
