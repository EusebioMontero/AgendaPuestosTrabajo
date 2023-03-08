package com.emc.apiContactos_01.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AreaAsignada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "areaAsignada", cascade = CascadeType.MERGE)
    List<Puesto> puestos = new ArrayList<>(0);

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "areaAsignada", cascade = CascadeType.MERGE)
    List<Sede> sedes = new ArrayList<>(0);

    private String nombre;

    public AreaAsignada(String nombre) {
        this.nombre = nombre;
    }
}
