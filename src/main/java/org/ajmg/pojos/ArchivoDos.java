package org.ajmg.pojos;

import java.io.IOException;

public class ArchivoDos {

    public void write(String texto, String file){
        System.out.println("escribiendo .... " + texto + " en : " + file);
    }

    public void close() throws IOException {
        System.out.println("cerrando... ");
    }
}
