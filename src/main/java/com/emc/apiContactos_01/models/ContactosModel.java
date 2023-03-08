package com.emc.apiContactos_01.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactosModel {

    private Long id;
    private String fotoUrl;
    private String nombre;
    private String apellido_1;
    private String apellido_2;
    private String mail;
    private String tel_corp;
    private String tel_part;
//    private CalendarioGuardiasModel calendarioGuardias;

}
