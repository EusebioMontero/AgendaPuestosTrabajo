package com.emc.apiContactos_01.controllers;

import com.emc.apiContactos_01.entities.Puesto;
import com.emc.apiContactos_01.services.PuestoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PuestosController {

     PuestoService puestoService;

    public PuestosController(PuestoService puestoService) {
        this.puestoService = puestoService;
    }

//TODO
//    @GetMapping("/api/puestos")
//    public Flux<Puesto> findAll(){
//        return Flux.fromIterable(puestoService.findAll());
//    }


    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/puestos")
    public List<Puesto> findAll(){
        return puestoService.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/puesto/{id}")
    public ResponseEntity<Puesto> find(@PathVariable Long id) {
        return puestoService.findById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("api/puesto")
    public ResponseEntity<Puesto> create(@RequestBody Puesto puesto) {
        return puestoService.create(puesto);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping("/api/puesto")
    public ResponseEntity<Puesto> update(@RequestBody Puesto puesto) {
        return puestoService.update(puesto);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("api/puesto/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return  puestoService.delete(id);
    }
}
