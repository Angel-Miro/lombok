package org.ajmg.pojos;

import java.io.Closeable;
import java.io.IOException;

public class Archivo implements Closeable {
    public void write(String texto, String file){
        System.out.println("escribiendo .... " + texto + " en : " + file);
    }

    @Override
    public void close() throws IOException {
        System.out.println("cerrando... ");
    }
}
