package com.company;

import com.company.mock.MockData;
import com.company.models.*;
import com.company.repository.FilesOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Autowired
    public static Cabeleireiro DataLoader() {
        Cabeleireiro cabeleireiro = null;
        cabeleireiro = FilesOperation.load();
        if(cabeleireiro == null) {
            cabeleireiro = new Cabeleireiro("Cabeleireira Lola","Rua da Juventude 231",15000.00,3,4);
            MockData mock = new MockData();
            mock.generateData(cabeleireiro);
            return cabeleireiro;
        }
        return new Cabeleireiro();
    }
}
