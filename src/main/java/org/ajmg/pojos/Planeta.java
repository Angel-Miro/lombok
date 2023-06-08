package org.ajmg.pojos;

import lombok.NonNull;

public class Planeta {
    private String nombre;

    private Planeta(){}

    public Planeta(@NonNull String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }
}
