package com.company.repository;

import com.company.models.Cabeleireiro;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;

public class FilesOperation {
    static final String CABELEIREIRO_FILE ="cabeleireiro.dat";

    public static Cabeleireiro load(){
        Cabeleireiro cabeleireiro = null;
        Path file = Paths.get(CABELEIREIRO_FILE);
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(file.toString()));
            cabeleireiro = (Cabeleireiro) o.readObject();
            o.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return cabeleireiro;
    }

    public static void save(Cabeleireiro cabeleireiro) {
        Path file = Paths.get(CABELEIREIRO_FILE);
        try{
            ObjectOutputStream o = new ObjectOutputStream(Files.newOutputStream(file, CREATE));
            o.writeObject(cabeleireiro);
            o.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
