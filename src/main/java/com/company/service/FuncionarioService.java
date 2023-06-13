package com.company.service;

import com.company.dto.*;
import com.company.models.Cabeleireiro;
import com.company.models.Funcionario;
import com.company.models.FuncionarioContainer;
import com.company.repository.FilesOperation;

import java.util.List;

public class FuncionarioService {
    public static FuncionarioListDto getFuncionarios() {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        List<Funcionario> list = cabeleireiro.getFuncionarios().getAll();
        FuncionarioListDto result = Mapper.funcionarioList2FuncionarioListDto(list);
        return result;
    }

    public static FuncionarioDto getFuncionarioInfo(int id) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        Funcionario item = cabeleireiro.getFuncionarios().get(id);
        FuncionarioDto result= Mapper.funcionario2FuncionarioDTO(item);
        return result;
    }

    public static void addFuncionario(FuncionarioDto arg){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        Funcionario item = Mapper.funcionarioDTO2Funcionario(arg);
        cabeleireiro.getFuncionarios().add(item);
        FilesOperation.save(cabeleireiro);
    }

    public static void updateFuncionario(int numeroFuncionario, FuncionarioDto arg){
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
