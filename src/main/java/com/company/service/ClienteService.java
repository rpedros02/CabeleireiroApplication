package com.company.service;

import com.company.dto.ClienteDTO;
import com.company.dto.ClienteListDTO;
import com.company.dto.Mapper;
import com.company.models.Cabeleireiro;
import com.company.models.ClienteContainer;
import com.company.repository.FilesOperation;


public class ClienteService {
    public static ClienteListDTO getClientes() {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        ClienteContainer list = cabeleireiro.getClientes();
        return Mapper.clienteContainer2ClienteListDTO(list);
    }

    public static ClienteDTO getClienteInfo(int id) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        return Mapper.cliente2ClienteDTO(cabeleireiro.getClientes().search(id));
    }

    public static void addCliente(ClienteDTO arg){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getClientes().add(Mapper.clienteDTO2Cliente(arg));
        FilesOperation.save(cabeleireiro);
    }

    public static void updateCliente(int numeroCliente,ClienteDTO arg){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getClientes().update(numeroCliente, arg.getNome(), Mapper.dateDTO2Date(arg.getDataNascimento()),arg.getNif(),arg.getGenero());
        FilesOperation.save(cabeleireiro);
    }

    public static void removeCliente(int number){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getClientes().remove(number);
        FilesOperation.save(cabeleireiro);
    }
}
