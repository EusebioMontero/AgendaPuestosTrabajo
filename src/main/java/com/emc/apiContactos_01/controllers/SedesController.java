package com.emc.apiContactos_01.controllers;

import com.emc.apiContactos_01.entities.Sede;
import com.emc.apiContactos_01.services.SedeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SedesController {

    SedeService sedeService;

    public SedesController(SedeService sedeService) {
        this.sedeService = sedeService;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/sedes")
    public List<Sede> findAll() {
        return sedeService.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/sede/{id}")
    public ResponseEntity<Sede> find(@PathVariable Long id) {
        return sedeService.findById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("api/sede")
    public ResponseEntity<Sede> create(@RequestBody Sede sede) {
        return sedeService.create(sede);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping("/api/sede")
    public ResponseEntity<Sede> update(@RequestBody Sede sede) {
        return sedeService.update(sede);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("api/sede/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return sedeService.delete(id);
    }

}
