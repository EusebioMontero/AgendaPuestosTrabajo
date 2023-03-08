package com.emc.apiContactos_01.models;

import com.emc.apiContactos_01.entities.AreaAsignada;
import com.emc.apiContactos_01.entities.Departamento;
import com.emc.apiContactos_01.entities.Seccion;
import com.emc.apiContactos_01.entities.Zona;
import com.emc.apiContactos_01.util.Turno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PuestosModel {

    private Long id;
    private String logoURL;
    private String descripcion;
    private boolean guardia;
    private Turno turrno;
    private Departamento departamento;
    private Seccion seccion;
    private Zona zona;
    private AreaAsignada areaAsignada;
    private ContactosModel contactosModel;


}
