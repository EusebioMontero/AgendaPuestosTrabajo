package com.emc.apiContactos_01.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String nombre;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "zona_id", referencedColumnName = "id")
    private Zona zona;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "area_asignada_id", referencedColumnName = "id")
    private AreaAsignada areaAsignada;

    public Sede(String nombre) {
        this.nombre = nombre;
    }
}
