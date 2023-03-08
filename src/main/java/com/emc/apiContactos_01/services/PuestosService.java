package com.emc.apiContactos_01.services;

import com.emc.apiContactos_01.entities.Puesto;
import com.emc.apiContactos_01.repositories.PuestosRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuestosService {

    PuestosRepository puestosRepository;

    public PuestosService(PuestosRepository puestosRepository) {
        this.puestosRepository = puestosRepository;
    }

    public List<Puesto> findAll() {
        return puestosRepository.findAll();
    }

    public ResponseEntity<Puesto> findById(Long id) {
        Optional<Puesto> puestosOpt = puestosRepository.findById(id);
        return puestosOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    public ResponseEntity<Puesto> create(Puesto puesto) {
        //TODO validar los campos, por ejemplo, el mail no puede estar ya en la BD
        if (puesto.getId() != null)//se está intentando actualizar  en lugar de crear
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(puestosRepository.save(puesto));
    }

    public ResponseEntity<Puesto> update(Puesto puesto) {
        //TODO revisar los campos que se van actualizar
        if (puesto.getId() == null)
            return ResponseEntity.badRequest().build();
        if (!puestosRepository.existsById(puesto.getId()))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(puestosRepository.save(puesto));
    }

    public ResponseEntity<String> delete(Long id) {
        if (!puestosRepository.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        try {
            puestosRepository.deleteById(id);
        } catch (Exception e) {
            if (e.getClass().equals(DataIntegrityViolationException.class)) {
                return new ResponseEntity<>("Violación de una restricción de Integridad Referencial", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }

        return ResponseEntity.noContent().build();
    }
}
