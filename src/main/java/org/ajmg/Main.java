package org.ajmg;

import lombok.Cleanup;
import lombok.val;
import lombok.var;
import org.ajmg.pojos.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

public class Main {


    public static void valAndVar() {
        final String texto = "texto";
        val text = "text";

        System.out.println("El tipo de dato del atributo con final  " + texto.getClass().getName());
        System.out.println("El tipo de dato del atributo con @val:: " + text.getClass().getName());


        int dato = 1000;
        var data = 1001;

        System.out.println("El tipo de dato del atributo es: " + dato);
        System.out.println("El tipo de dato del atributo con @val: " + data);
        data = 2000;
        System.out.println("El tipo de dato del atributo con @val: " + data);
    }

    public static void nonNullLombok() {
        Planeta p = new Planeta("tierra");
        System.out.println("EL planeta es: " + p.getNombre());

    }

    public static void cleanUp() {
        /**
         * Existe la forma tradicional de crear un try with resources o anotar el
         * com @CleanUp
         */

        //try with resources
        /*
        try(Archivo a = new Archivo()){
            a.write("prueba","prueba.txt");
        } catch (IOException e) {
           e.printStackTrace();
        }
         */
        try {
            @Cleanup
            Archivo a = new Archivo();
            a.write("prueba", "prueba.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //esto es cuando no se implementa Closeable
        //se puede definir el metodo a cerrar como argumento a la anotacion
        try {
            @Cleanup("close")
            Archivo a = new Archivo();
            a.write("prueba dos", "pruebaDos.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void getterSetter() {
        Cuenta c = new Cuenta();
        c.setValues();
        System.out.println("el valor de los atributos es: " + c.getIdCuenta().intValue());
    }

    public static void toStringE() {
        Cuenta c = new Cuenta();
        c.setValues();
        System.out.println(c.toString());
    }

    public static void equalsAndHAshCode() {
        Cuenta c = new Cuenta();
        Cuenta c2 = new Cuenta();
        c.setValues();
        c2.setValues();
        System.out.println("Los objectos son iguales? : " + c.equals(c2));
    }

    public static void constuctors() {
        Cuenta c = new Cuenta();
        //Cuenta c2 = new Cuenta(new BigDecimal("1000"), true);
        Cuenta c3 = new Cuenta(new BigDecimal("1000"), true, "angel");
        System.out.println(c.toString());
        //System.out.println(c2.toString());
        System.out.println(c3.toString());
    }

    public static void data() {
        Persona p = new Persona();
        p.setEdad(29);
        p.setNombre("angel");
        p.setGenero('H');
        System.out.println(p.toString());
    }

    public static void value() {
        Registro r = new Registro(1, new Date(), "1234rwedsfge$$#$%$#");
        System.out.println(r.getIdRegistro());
        System.out.println(r.getFechaRegistro());
        System.out.println(r.getFirmaDigital());
        //genera puro getter, ya que no permite modificar
    }

    public static void builder() {
        Cancion c = Cancion.builder().nombre("Life in the Tropics").
                autor("Cienfue").fechaLanzamiento(new Date()).album("Life in the Tropics").
                genero("Indie").duracion(2.56f).build();
        System.out.println(c.toString());
    }

    public static void with(){
        Coordenada c = new Coordenada(5.3f,7.2f);
        Coordenada c2 = c.withX(34.5f).withY(14.3f);
        System.out.println(c);
        System.out.println(c2);
    }

    public static void main(String[] args) {
        valAndVar();
        nonNullLombok();
        cleanUp();
        getterSetter();
        toStringE();
        equalsAndHAshCode();
        constuctors();
        data();
        value();
        builder();
        with();
    }
}