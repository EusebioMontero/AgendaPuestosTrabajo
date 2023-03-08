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
public class Seccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String nombre;

    //Relaciones
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "seccion", cascade = CascadeType.MERGE)
    List<Puesto> puestos = new ArrayList<>(0);
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "departamento_id", referencedColumnName = "id")
    private Departamento departamento;

    public Seccion(String nombre) {
        this.nombre = nombre;
    }
}
