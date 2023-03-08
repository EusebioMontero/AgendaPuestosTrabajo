package com.emc.apiContactos_01.util;

import java.time.LocalTime;

public enum Turno {
    Mañana(LocalTime.of(8, 0), LocalTime.of(16, 0)),
    Tarde(LocalTime.of(16, 0), LocalTime.of(0, 0)),
    Noche(LocalTime.of(0,0), LocalTime.of(8, 0));

    private LocalTime inicio;
    private LocalTime fin;

    Turno(LocalTime inicio, LocalTime fin){
        this.inicio = inicio;
        this.fin=fin;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public LocalTime getFin() {
        return fin;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }

    public void setFin(LocalTime fin) {
        this.fin = fin;
    }
}
