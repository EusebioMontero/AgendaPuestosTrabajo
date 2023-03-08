package com.emc.apiContactos_01.services;

import com.emc.apiContactos_01.entities.Zona;
import com.emc.apiContactos_01.repositories.ZonasRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZonasService {

    ZonasRepository zonasRepository;

    public ZonasService(ZonasRepository zonasRepository) {
        this.zonasRepository = zonasRepository;
    }

    public List<Zona> findAll() {
        return zonasRepository.findAll();
    }

    public ResponseEntity<Zona> findById(Long id) {
        Optional<Zona> zonasOpt = zonasRepository.findById(id);
        return zonasOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Zona> create(Zona zona) {
        //TODO validar los campos, por ejemplo, el mail no puede estar ya en la BD
        if (zona.getId() != null)//se está intentando actualizar  en lugar de crear
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(zonasRepository.save(zona));
    }

    public ResponseEntity<Zona> update(Zona zona) {
        //TODO revisar los campos que se van actualizar
        if (zona.getId() == null)
            return ResponseEntity.badRequest().build();
        if (!zonasRepository.existsById(zona.getId()))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(zonasRepository.save(zona));
    }

    public ResponseEntity<String> delete(Long id) {
        if (!zonasRepository.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        try {
            zonasRepository.deleteById(id);
        } catch (Exception e) {
            if (e.getClass().equals(DataIntegrityViolationException.class)) {
                return new ResponseEntity<>("Violación de una restricción de Integridad Referencial", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }

        return ResponseEntity.noContent().build();
    }

}
