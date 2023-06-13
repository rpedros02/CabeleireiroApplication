package com.company.service;

import com.company.dto.ClienteDto;
import com.company.dto.ClienteListDto;
import com.company.dto.Mapper;
import com.company.models.Cabeleireiro;
import com.company.models.Cliente;
import com.company.models.Date;
import com.company.repository.FilesOperation;

import java.util.List;


public class ClienteService {
    public static ClienteListDto getClientes() {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        List<Cliente> list = cabeleireiro.getClientes().getAll();
        ClienteListDto result= Mapper.clienteList2ClienteListDto(list);
        return result;
    }

    public static ClienteDto getClienteInfo(int id) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        Cliente item = cabeleireiro.getClientes().get(id);
        ClienteDto result = Mapper.cliente2ClienteDTO(item);
        return result;
    }

    public static void addCliente(ClienteDto arg){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        Cliente item = Mapper.clienteDTO2Cliente(arg);
        cabeleireiro.getClientes().add(item);
        FilesOperation.save(cabeleireiro);
    }

    public static void updateCliente(int numeroCliente, ClienteDto arg){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        Date date= Mapper.dateDTO2Date(arg.getDataNascimento());
        cabeleireiro.getClientes().update(numeroCliente, arg.getNome(), date,arg.getNif());
        FilesOperation.save(cabeleireiro);
    }

    public static void removeCliente(int number){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getClientes().remove(number);
        FilesOperation.save(cabeleireiro);
    }
}
