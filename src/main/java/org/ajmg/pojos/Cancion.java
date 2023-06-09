package org.ajmg.pojos;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Builder
@ToString
public class Cancion {
    private String nombre;
    private String autor;
    private Date fechaLanzamiento;
    private String album;
    private String genero;
    private float duracion;
    @Builder.Default
    private int anio = 2023;
}
