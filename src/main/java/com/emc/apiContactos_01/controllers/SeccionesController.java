package com.emc.apiContactos_01.controllers;

import com.emc.apiContactos_01.entities.Seccion;
import com.emc.apiContactos_01.services.SeccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeccionesController {

    SeccionService seccionService;

    public SeccionesController(SeccionService seccionService) {
        this.seccionService = seccionService;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/secciones")
    public List<Seccion> findAll(){
        return seccionService.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/seccion/{id}")
    public ResponseEntity<Seccion> find(@PathVariable Long id) {
        return seccionService.findById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("api/seccion")
    public ResponseEntity<Seccion> create(@RequestBody Seccion seccion) {
        return seccionService.create(seccion);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping("/api/seccion")
    public ResponseEntity<Seccion> update(@RequestBody Seccion seccion) {
        return seccionService.update(seccion);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("api/seccion/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return  seccionService.delete(id);
    }
}
