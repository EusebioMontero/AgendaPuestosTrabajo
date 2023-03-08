package com.emc.apiContactos_01.services;

import com.emc.apiContactos_01.entities.Contacto;

import com.emc.apiContactos_01.repositories.ContactosRepository;
import com.emc.apiContactos_01.repositories.PuestosRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class ContactosService {

    ContactosRepository contactosRepository;
    PuestosRepository puestosRepository;


    public ContactosService(ContactosRepository contactosRepository, PuestosRepository puestosRepository) {
        this.contactosRepository = contactosRepository;
        this.puestosRepository = puestosRepository;
    }

    public List<Contacto> findByPuesto_id(Long id){
        return  puestosRepository.findById(id).stream()
                .flatMap(puestos -> puestos.getContactos().stream()).toList();
    }


//    public List<Contacto> findBySede(String sede) {
//        return contactosRepository.contactosBySede(sede);
//    }

    public List<Contacto> findByGuardia(boolean guardia) {
        return puestosRepository.findByGuardia(guardia).stream()
                .flatMap(puestos -> puestos.getContactos().stream()).toList();
    }

    public List<Contacto> findAll() {
        return contactosRepository.findAll();
    }

    public ResponseEntity<Contacto> findById(Long id) {
        Optional<Contacto> contactoOpt = contactosRepository.findById(id);
        return contactoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Contacto> create(Contacto contacto) {
        //TODO validar los campos, por ejemplo, el mail no puede estar ya en la BD
        if (contacto.getId() != null)//se está intentando crear en lugar de actualizar
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(contactosRepository.save(contacto));
    }

    public ResponseEntity<Contacto> update(Contacto contacto) {
        //TODO revisar los campos que se van actualizar
        if (contacto.getId() == null)
            return ResponseEntity.badRequest().build();
        if (!contactosRepository.existsById(contacto.getId()))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(contactosRepository.save(contacto));
    }

    //    public ResponseEntity<Contacto> delete(Long id) {
//            contactosRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
    public ResponseEntity<String> delete(Long id) {
        if (!contactosRepository.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        try {
            contactosRepository.deleteById(id);
        } catch (Exception e) {
            if (e.getClass().equals(DataIntegrityViolationException.class)) {
                return new ResponseEntity<>("Violación de una restricción de Integridad Referencial", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }
        return ResponseEntity.noContent().build();
    }
}
