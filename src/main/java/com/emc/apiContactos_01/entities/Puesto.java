package com.emc.apiContactos_01.entities;

import com.emc.apiContactos_01.util.Turno;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString(exclude = "contacto")
@NoArgsConstructor

public class Puesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String logoURL;
    private String descripcion;
    private boolean guardia;


    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "puesto", cascade = CascadeType.PERSIST)
    private List<Contacto> contactos = new ArrayList<>(0);

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "seccion_id", referencedColumnName = "id")
    private Seccion seccion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "area_asignada_id", referencedColumnName = "id")
    private AreaAsignada areaAsignada;

    public Puesto(String descripcion, Turno turno, boolean guardia) {
        this.descripcion = descripcion;
        this.guardia = guardia;
    }


}
