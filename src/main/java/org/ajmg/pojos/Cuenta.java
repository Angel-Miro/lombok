package org.ajmg.pojos;

import lombok.*;

import java.math.BigDecimal;

@Getter (value = AccessLevel.PUBLIC)
@Setter (value = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
public class Cuenta {

    @EqualsAndHashCode.Include
    private BigDecimal idCuenta;

    @EqualsAndHashCode.Include
    private boolean isActive;

    @ToString.Exclude
    //@EqualsAndHashCode.Exclude
    private String name;

    public void setValues (){
        setIdCuenta(new BigDecimal("100001"));
        setActive(true);
        setName("angel");
    }
}
