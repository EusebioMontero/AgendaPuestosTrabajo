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
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String zona;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "zona", cascade = CascadeType.MERGE)
    List<Sede> sedes = new ArrayList<>(0);

    public Zona(String zona) {
        this.zona = zona;
    }
}
