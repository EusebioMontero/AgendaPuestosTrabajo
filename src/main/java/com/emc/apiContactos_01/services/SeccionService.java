package com.emc.apiContactos_01.services;

import com.emc.apiContactos_01.entities.Seccion;
import com.emc.apiContactos_01.repositories.SeccionesRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeccionService {

    SeccionesRepository seccionesRepository;

    public SeccionService(SeccionesRepository seccionesRepository) {
        this.seccionesRepository = seccionesRepository;
    }

    public List<Seccion> findAll() {
        return seccionesRepository.findAll();
    }

    public ResponseEntity<Seccion> findById(Long id) {
        Optional<Seccion> seccionOpt = seccionesRepository.findById(id);
        return seccionOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    public ResponseEntity<Seccion> create(Seccion seccion) {
        //TODO validar los campos, por ejemplo, el mail no puede estar ya en la BD
        if (seccion.getId() != null)//se está intentando actualizar  en lugar de crear
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(seccionesRepository.save(seccion));
    }

    public ResponseEntity<Seccion> update(Seccion seccion) {
        //TODO revisar los campos que se van actualizar
        if (seccion.getId() == null)
            return ResponseEntity.badRequest().build();
        if (!seccionesRepository.existsById(seccion.getId()))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(seccionesRepository.save(seccion));
    }

    public ResponseEntity<String> delete(Long id) {
        if (!seccionesRepository.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        try {
            seccionesRepository.deleteById(id);
        } catch (Exception e) {
            if (e.getClass().equals(DataIntegrityViolationException.class)) {
                return new ResponseEntity<>("Violación de una restricción de Integridad Referencial", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }

        return ResponseEntity.noContent().build();
    }
}
