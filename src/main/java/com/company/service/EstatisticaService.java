package com.company.service;

import com.company.dto.FuncionarioDTO;
import com.company.dto.Mapper;
import com.company.dto.ServicoListDTO;
import com.company.models.*;
import com.company.repository.FilesOperation;

public class EstatisticaService {
    public static ServicoListDTO getServicosPorFuncionario(long id) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        ServicosContainer container = new ServicosContainer();
        for (Servico s : cabeleireiro.getServicos().getServicos()) {
            if (s.getNumFuncionario() == id) {
                container.getServicos().add(s);
            }
        }
        return Mapper.servicoList2ServicoListDTO(container);
    }

    public static int getNServicosPorFuncionario(long id) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        int count = 0;
        for (Servico s : cabeleireiro.getServicos().getServicos()) {
            if (s.getNumFuncionario() == id) {
                count++;
            }
        }
        return count;
    }

    public static FuncionarioDTO getFuncionarioMaisServicos(){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        int max = 0;
        long idmax = 0;
        for(Funcionario f : cabeleireiro.getFuncionarios().getFuncionarios()){
            int count = getNServicosPorFuncionario(f.getNumFuncionario());
            if(count > max){
                max = count;
                idmax = f.getNumFuncionario();
            }
        }
        return Mapper.funcionario2FuncionarioDTO(cabeleireiro.getFuncionarios().search((int) idmax));
    }
}
