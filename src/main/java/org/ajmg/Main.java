package org.ajmg;

import lombok.Cleanup;
import lombok.val;
import lombok.var;
import org.ajmg.pojos.Archivo;
import org.ajmg.pojos.Cuenta;
import org.ajmg.pojos.Persona;
import org.ajmg.pojos.Planeta;

import java.io.IOException;
import java.math.BigDecimal;

public class Main {


    public static void valAndVar(){
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

    public static void nonNullLombok(){
        Planeta p = new Planeta("tierra");
        System.out.println("EL planeta es: " + p.getNombre());

    }

    public static void cleanUp(){
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
        try{
            @Cleanup
            Archivo a = new Archivo();
            a.write("prueba","prueba.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //esto es cuando no se implementa Closeable
        //se puede definir el metodo a cerrar como argumento a la anotacion
        try{
            @Cleanup("close")
            Archivo a = new Archivo();
            a.write("prueba dos","pruebaDos.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void getterSetter(){
        Cuenta c = new Cuenta();
        c.setValues();
        System.out.println("el valor de los atributos es: " + c.getIdCuenta().intValue());
    }

    public static void toStringE(){
        Cuenta c = new Cuenta();
        c.setValues();
        System.out.println(c.toString());
    }

    public static void equalsAndHAshCode(){
        Cuenta c = new Cuenta();
        Cuenta c2 = new Cuenta();
        c.setValues();
        c2.setValues();
        System.out.println("Los objectos son iguales? : " + c.equals(c2));
    }

    public static void constuctors(){
        Cuenta c = new Cuenta();
        //Cuenta c2 = new Cuenta(new BigDecimal("1000"), true);
        Cuenta c3 = new Cuenta(new BigDecimal("1000"), true, "angel");
        System.out.println(c.toString());
        //System.out.println(c2.toString());
        System.out.println(c3.toString());
    }

    public static void data(){
        Persona p = new Persona();
        p.setEdad(29);
        p.setNombre("angel");
        p.setGenero('H');
        System.out.println(p.toString());
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
    }
}