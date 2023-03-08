package com.emc.apiContactos_01.controllers;

import com.emc.apiContactos_01.entities.Sede;
import com.emc.apiContactos_01.services.SedesService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SedesController {

    SedesService sedesService;

    public SedesController(SedesService sedesService) {
        this.sedesService = sedesService;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/sedes")
    public List<Sede> findAll() {
        return sedesService.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/sede/{id}")
    public ResponseEntity<Sede> find(@PathVariable Long id) {
        return sedesService.findById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("api/sede")
    public ResponseEntity<Sede> create(@RequestBody Sede sede) {
        return sedesService.create(sede);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping("/api/sede")
    public ResponseEntity<Sede> update(@RequestBody Sede sede) {
        return sedesService.update(sede);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("api/sede/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return sedesService.delete(id);
    }

}
