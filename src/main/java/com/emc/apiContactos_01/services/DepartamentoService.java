package com.emc.apiContactos_01.services;

import com.emc.apiContactos_01.entities.Departamento;
import com.emc.apiContactos_01.repositories.DepartamentosRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DepartamentoService {
    DepartamentosRepository departamentosRepository;

    public DepartamentoService(DepartamentosRepository departamentosRepository) {
        this.departamentosRepository = departamentosRepository;
    }

    public List<Departamento> findAll() {
        return departamentosRepository.findAll();
    }

    public ResponseEntity<Departamento> findById(Long id) {
        Optional<Departamento> deptOpt = departamentosRepository.findById(id);
        return deptOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    public ResponseEntity<Departamento> create(Departamento departamento) {
        //TODO validar los campos, por ejemplo, el mail no puede estar ya en la BD
        if (departamento.getId() != null)//se está intentando actualizar  en lugar de crear
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(departamentosRepository.save(departamento));
    }
    public ResponseEntity<Departamento> update(Departamento departamento) {
        //TODO revisar los campos que se van actualizar
        if (departamento.getId() == null)
            return ResponseEntity.badRequest().build();
        if (!departamentosRepository.existsById(departamento.getId()))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(departamentosRepository.save(departamento));
    }
    public ResponseEntity<String> delete(Long id) {
        if (!departamentosRepository.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        try {
            departamentosRepository.deleteById(id);
        } catch (Exception e) {
            if (e.getClass().equals(DataIntegrityViolationException.class)) {
                return new ResponseEntity<>("Violación de una restricción de Integridad Referencial", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }
        return ResponseEntity.noContent().build();
    }
}
