package org.ajmg.pojos;

import lombok.Value;

import java.util.Date;

@Value
public class Registro {
    private Integer idRegistro;
    private Date fechaRegistro;
    private String firmaDigital;
}
