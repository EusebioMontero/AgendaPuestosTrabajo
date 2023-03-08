package com.emc.apiContactos_01.controllers;

import com.emc.apiContactos_01.entities.Puesto;
import com.emc.apiContactos_01.services.PuestosService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PuestosController {

     PuestosService puestosService;

    public PuestosController(PuestosService puestosService) {
        this.puestosService = puestosService;
    }

//TODO
//    @GetMapping("/api/puestos")
//    public Flux<Puesto> findAll(){
//        return Flux.fromIterable(puestosService.findAll());
//    }


    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/puestos")
    public List<Puesto> findAll(){
        return puestosService.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/puesto/{id}")
    public ResponseEntity<Puesto> find(@PathVariable Long id) {
        return puestosService.findById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("api/puesto")
    public ResponseEntity<Puesto> create(@RequestBody Puesto puesto) {
        return puestosService.create(puesto);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping("/api/puesto")
    public ResponseEntity<Puesto> update(@RequestBody Puesto puesto) {
        return puestosService.update(puesto);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("api/puesto/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return  puestosService.delete(id);
    }
}
