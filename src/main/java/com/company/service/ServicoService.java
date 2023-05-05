package com.company.service;

import com.company.dto.*;
import com.company.models.*;
import com.company.repository.FilesOperation;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;

public class ServicoService {
    public static ServicoListDTO getServicos() {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        ServicosContainer list = cabeleireiro.getServicos();
        return Mapper.servicoList2ServicoListDTO(list);
    }

    public static ServicoDTO getServicoInfo(int id) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        return Mapper.servico2ServicoDTO(cabeleireiro.getServicos().search(id));
    }

    public static void addServico(ServicoDTO arg){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getServicos().add(Mapper.servicodto2Servico(arg));
        FilesOperation.save(cabeleireiro);
    }

    public static void updateServico(int numPedido,ServicoDTO arg){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getServicos().update(numPedido, arg.getNumCliente(), Mapper.dateDTO2Date(arg.getDataServico()),Mapper.horarioServicoDTO2HorarioServico(arg.getHorarioServico()));
        FilesOperation.save(cabeleireiro);
    }

    public static void removeServico(int number){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getServicos().remove(number);
        FilesOperation.save(cabeleireiro);
    }
}
