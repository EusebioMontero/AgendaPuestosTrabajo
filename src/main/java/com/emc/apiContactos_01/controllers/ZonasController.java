package com.emc.apiContactos_01.controllers;

import com.emc.apiContactos_01.entities.Zona;
import com.emc.apiContactos_01.services.ZonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ZonasController {

    ZonaService zonaService;

    public ZonasController(ZonaService zonaService) {
        this.zonaService = zonaService;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/zonas")
    public List<Zona> findAll() {
        return zonaService.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/zona/{id}")
    public ResponseEntity<Zona> find(@PathVariable Long id) {
        return zonaService.findById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("api/zona")
    public ResponseEntity<Zona> create(@RequestBody Zona zona) {
        return zonaService.create(zona);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping("/api/zona")
    public ResponseEntity<Zona> update(@RequestBody Zona zona) {
        return zonaService.update(zona);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("api/zona/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return zonaService.delete(id);
    }
}
