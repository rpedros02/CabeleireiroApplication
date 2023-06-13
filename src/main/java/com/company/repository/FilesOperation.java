package com.company.repository;

import com.company.DataLoader;
import com.company.mock.MockData;
import com.company.models.Cabeleireiro;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;

public class FilesOperation {
    static final String CABELEIREIRO_FILE ="cabeleireiro2.dat";

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
            if (cabeleireiro == null || cabeleireiro.getClientes() == null || cabeleireiro.getClientes().size() == 0) {
                cabeleireiro = new Cabeleireiro("Cabeleireira Lola", "Rua da Juventude 231", 15000.00, 3, 4);
                MockData mock = new MockData();
                mock.generateData(cabeleireiro);
                save(cabeleireiro);
                return cabeleireiro;
            }
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
