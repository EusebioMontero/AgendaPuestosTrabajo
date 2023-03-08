package com.emc.apiContactos_01.services;

import com.emc.apiContactos_01.entities.Sede;
import com.emc.apiContactos_01.repositories.SedesRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedeService {

    SedesRepository sedesRepository;

    public SedeService(SedesRepository sedesRepository) {
        this.sedesRepository = sedesRepository;
    }

    public List<Sede> findAll() {
        return sedesRepository.findAll();
    }

    public ResponseEntity<Sede> findById(Long id) {
        Optional<Sede> sedesOpt = sedesRepository.findById(id);
        return sedesOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Sede> create(Sede sede) {
        //TODO validar los campos, por ejemplo, el mail no puede estar ya en la BD
        if (sede.getId() != null)//se está intentando actualizar  en lugar de crear
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(sedesRepository.save(sede));
    }

    public ResponseEntity<Sede> update(Sede sede) {
        //TODO revisar los campos que se van actualizar
        if (sede.getId() == null)
            return ResponseEntity.badRequest().build();
        if (!sedesRepository.existsById(sede.getId()))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sedesRepository.save(sede));
    }

    public ResponseEntity<String> delete(Long id) {
        if (!sedesRepository.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        try {
            sedesRepository.deleteById(id);
        } catch (Exception e) {
            if (e.getClass().equals(DataIntegrityViolationException.class)) {
                return new ResponseEntity<>("Violación de una restricción de Integridad Referencial", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }

        return ResponseEntity.noContent().build();
    }
}
