package com.emc.apiContactos_01.controllers;

import com.emc.apiContactos_01.entities.Departamento;
import com.emc.apiContactos_01.services.DepartamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class DepartamentosController {
    DepartamentoService departamentoService;

    public DepartamentosController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/departamentos")
    public List<Departamento> findAll(){
        return departamentoService.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/departamento/{id}")
    public ResponseEntity<Departamento> find(@PathVariable Long id) {
        return departamentoService.findById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("api/departamento")
    public ResponseEntity<Departamento> create(@RequestBody Departamento departamento) {
        return departamentoService.create(departamento);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping("/api/departamento")
    public ResponseEntity<Departamento> update(@RequestBody Departamento departamento) {
        return departamentoService.update(departamento);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @DeleteMapping("api/departamento/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return  departamentoService.delete(id);
    }
}
