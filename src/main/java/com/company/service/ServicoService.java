package com.company.service;

import com.company.dto.*;
import com.company.models.*;
import com.company.repository.FilesOperation;

import java.util.List;

public class ServicoService {
    public static ServicoListDto getServicos() {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        List<Servico> list=cabeleireiro.getServicos().getAll();
        ServicoListDto result = Mapper.servicoList2ServicoListDto(list);
        return result;
    }

    public static ServicoDto getServicoInfo(int id) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        return Mapper.servico2ServicoDTO(cabeleireiro.getServicos().search(id));
    }
    public static void addServico(ServicoDto arg){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getServicos().add(Mapper.servicoDto2Servico(arg));
        FilesOperation.save(cabeleireiro);
    }

    public static void updateServico(int numeroPedido,ServicoDto arg){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getServicos().update(numeroPedido, arg.getNumeroCliente(),arg.getNumeroFuncionario(), Mapper.dateDTO2Date(arg.getDataServico()),Mapper.horarioServicoDTO2HorarioServico(arg.getHorarioServico()));
        FilesOperation.save(cabeleireiro);
    }

    public static void removeServico(int number){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getServicos().remove(number);
        FilesOperation.save(cabeleireiro);
    }
}
