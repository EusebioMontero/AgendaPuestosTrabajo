package com.emc.apiContactos_01.entities;


import com.emc.apiContactos_01.models.CalendarioGuardiasModel;
import com.emc.apiContactos_01.util.Turno;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
@ToString(exclude = "puesto")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fotoUrl;
    private String nombre;
    private String apellido_1;
    private String apellido_2;
    private String mail;
    private String tel_corp;
    private String tel_part;
    private Turno turno;
//    private CalendarioGuardiasModel calendarioGuardias;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "puesto_id", referencedColumnName = "id")
    private Puesto puesto;


    public Contacto(String nombre, String apellido_1, String apellido_2, String mail, String tel_corp, String tel_part, Puesto puesto, Turno turno) {
        this.nombre = nombre;
        this.apellido_1 = apellido_1;
        this.apellido_2 = apellido_2;
        this.mail = mail;
        this.tel_corp = tel_corp;
        this.tel_part = tel_part;
        this.puesto = puesto;
        this.turno = turno;
    }
}
