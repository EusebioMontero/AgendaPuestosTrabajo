package com.emc.apiContactos_01.services;

import com.emc.apiContactos_01.entities.AreaAsignada;
import com.emc.apiContactos_01.repositories.AreaAsignadaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {

    AreaAsignadaRepository areaAsignadaRepository;

    public AreaService(AreaAsignadaRepository areaAsignadaRepository) {
        this.areaAsignadaRepository = areaAsignadaRepository;
    }

    public List<AreaAsignada> findAll() {
        return areaAsignadaRepository.findAll();
    }

    public ResponseEntity<AreaAsignada> findById(Long id) {
        Optional<AreaAsignada> areaOpt = areaAsignadaRepository.findById(id);
        return areaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    public ResponseEntity<AreaAsignada> create(AreaAsignada areaAsignada) {
        //TODO validar los campos, por ejemplo, el mail no puede estar ya en la BD
        if (areaAsignada.getId() != null)//se está intentando actualizar  en lugar de crear
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(areaAsignadaRepository.save(areaAsignada));
    }

    public ResponseEntity<AreaAsignada> update(AreaAsignada areaAsignada) {
        //TODO revisar los campos que se van actualizar
        if (areaAsignada.getId() == null)
            return ResponseEntity.badRequest().build();
        if (!areaAsignadaRepository.existsById(areaAsignada.getId()))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(areaAsignadaRepository.save(areaAsignada));
    }


    //    public ResponseEntity<Puesto> delete(Long id) {
//        puestosRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
    public ResponseEntity<String> delete(Long id) {
        if (!areaAsignadaRepository.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        try {
            areaAsignadaRepository.deleteById(id);
        }catch (DataIntegrityViolationException ex){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
            return new ResponseEntity<>("Violación de una restricción de Integridad Referencial"+ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
//        } catch (DataIntegrityViolationException e) {
//            if (e.getClass().equals(DataIntegrityViolationException.class)) {
//                return new ResponseEntity<>("Violación de una restricción de Integridad Referencial", HttpStatus.UNPROCESSABLE_ENTITY);
//            }
//        }

        return ResponseEntity.noContent().build();
    }
}
