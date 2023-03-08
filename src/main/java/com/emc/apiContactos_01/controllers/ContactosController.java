package com.emc.apiContactos_01.controllers;

import com.emc.apiContactos_01.entities.Contacto;
import com.emc.apiContactos_01.services.ContactosService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactosController {

    ContactosService contactosService;

    public ContactosController(ContactosService contactosService) {
        this.contactosService= contactosService;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/contactos")
    public List<Contacto> findAll(){
        return contactosService.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/api/contacto/{id}")
    public ResponseEntity<Contacto> find(@PathVariable Long id) {
        return contactosService.findById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("api/contacto")
    public ResponseEntity<Contacto> create(@RequestBody Contacto contacto) {
        return contactosService.create(contacto);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping("/api/contacto")
    public ResponseEntity<Contacto> update(@RequestBody Contacto contacto) {
        return contactosService.update(contacto);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("api/contacto/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return  contactosService.delete(id);
    }
}
