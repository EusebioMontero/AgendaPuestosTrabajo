package com.emc.apiContactos_01.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String nombre;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "departamento", cascade = CascadeType.MERGE)
    private List<Seccion> secciones = new ArrayList<>(0);

    public Departamento(String nombre) {
        this.nombre = nombre;
    }
}
