package com.emc.apiContactos_01.controllers;

import com.emc.apiContactos_01.entities.AreaAsignada;
import com.emc.apiContactos_01.services.AreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AreaController {

    AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/areas")
    public List<AreaAsignada> findAll(){
        return areaService.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/area/{id}")
    public ResponseEntity<AreaAsignada> find(@PathVariable Long id) {
        return areaService.findById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("api/area")
    public ResponseEntity<AreaAsignada> create(@RequestBody AreaAsignada areaAsignada) {
        return areaService.create(areaAsignada);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping("/api/area")
    public ResponseEntity<AreaAsignada> update(@RequestBody AreaAsignada areaAsignada) {
        return areaService.update(areaAsignada);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("api/area/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return  areaService.delete(id);
    }
}
