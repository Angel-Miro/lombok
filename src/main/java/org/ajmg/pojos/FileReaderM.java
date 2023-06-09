package org.ajmg.pojos;

import lombok.SneakyThrows;
import lombok.extern.java.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Log
public class FileReaderM {

    @SneakyThrows
    public void readFile(){
        File file = new File("/home/aztlan/Documentos/java/certificacion/certficacionJava.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null){
            log.info(line);
            //System.out.println(line);
        }
    }

}
