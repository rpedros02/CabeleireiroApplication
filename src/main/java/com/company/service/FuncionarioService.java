package com.company.service;

import com.company.dto.*;
import com.company.models.Cabeleireiro;
import com.company.models.FuncionarioContainer;
import com.company.repository.FilesOperation;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;

public class FuncionarioService {
    public static FuncionarioListDTO getFuncionarios() {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        FuncionarioContainer list = cabeleireiro.getFuncionarios();
        return Mapper.funcionarioContainer2FuncionarioListDTO(list);
    }

    public static FuncionarioDTO getFuncionarioInfo(int id) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        return Mapper.funcionario2FuncionarioDTO(cabeleireiro.getFuncionarios().search(id));
    }

    public static void addFuncionario(FuncionarioDTO arg){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getFuncionarios().add(Mapper.funcionarioDTO2Funcionario(arg));
        FilesOperation.save(cabeleireiro);
    }

    public static void updateFuncionario(int numeroFuncionario,FuncionarioDTO arg){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getFuncionarios().update(numeroFuncionario,Mapper.funcionarioDTO2Funcionario(arg));
        FilesOperation.save(cabeleireiro);
    }

    public static void removeFuncionario(int number){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getFuncionarios().remove(number);
        FilesOperation.save(cabeleireiro);
    }
}
