package com.company.service;

import ch.qos.logback.core.net.server.Client;
import com.company.dto.*;
import com.company.models.*;
import com.company.repository.FilesOperation;

import java.util.ArrayList;
import java.util.List;

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

    public static FuncionarioDTO getFuncionarioMaisServicos() {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        int max = 0;
        long idmax = 0;
        for (Funcionario f : cabeleireiro.getFuncionarios().getFuncionarios()) {
            int count = getNServicosPorFuncionario(f.getNumFuncionario());
            if (count > max) {
                max = count;
                idmax = f.getNumFuncionario();
            }
        }
        return Mapper.funcionario2FuncionarioDTO(cabeleireiro.getFuncionarios().search((int) idmax));
    }

    public static ClienteListDTO getNClientesMaisVelhos(int n) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        ArrayList<Cliente> clientes = cabeleireiro.getClientes().getAll();
        ArrayList<Cliente> clientesMaisVelhos = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (clientesMaisVelhos.size() < n) {
                clientesMaisVelhos.add(cliente);
                continue;
            }
            for (int i = 0; i < clientesMaisVelhos.size(); i++) {
                if (cliente.getDataNascimento().isEarlier(clientesMaisVelhos.get(i).getDataNascimento())) {
                    clientesMaisVelhos.add(i, cliente);
                    clientesMaisVelhos.remove(n);
                    break;
                }
            }
        }
        ClienteContainer result = new ClienteContainer();
        for (Cliente cliente : clientesMaisVelhos) {
            result.add(cliente.getNumeroCliente(), cliente);
        }
        return Mapper.clienteContainer2ClienteListDTO(result);
    }

    public static ClienteListDTO getNClientesMaisNovos(int n) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        ArrayList<Cliente> clientes = cabeleireiro.getClientes().getAll();
        ArrayList<Cliente> clientesMaisNovos = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (clientesMaisNovos.size() < n) {
                clientesMaisNovos.add(cliente);
            }
            for (int i = 0; i < clientesMaisNovos.size(); i++) {
                if (cliente.getDataNascimento().isLater(clientesMaisNovos.get(i).getDataNascimento())) {
                    clientesMaisNovos.add(i, cliente);
                    clientesMaisNovos.remove(n);
                    break;
                }
            }
        }
        ClienteContainer result = new ClienteContainer();
        for (Cliente cliente : clientesMaisNovos) {
            result.add(cliente.getNumeroCliente(), cliente);
        }
        return Mapper.clienteContainer2ClienteListDTO(result);
    }

    public static FuncionarioListDTO getNFuncionariosMaisVelhos(int n) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        ArrayList<Funcionario> funcionarios = cabeleireiro.getFuncionarios().getFuncionarios();
        ArrayList<Funcionario> funcionariosMaisVelhos = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            if (funcionariosMaisVelhos.size() < n) {
                funcionariosMaisVelhos.add(funcionario);
            }
            for (int i = 0; i < funcionariosMaisVelhos.size(); i++) {
                if (funcionario.getDataNascimento().isEarlier(funcionariosMaisVelhos.get(i).getDataNascimento())) {
                    funcionariosMaisVelhos.add(i, funcionario);
                    funcionariosMaisVelhos.remove(n);
                    break;
                }
            }
        }
        FuncionarioContainer result = new FuncionarioContainer();
        for (Funcionario funcionario : funcionariosMaisVelhos) {
            result.add(funcionario.getNumFuncionario(), funcionario);
        }
        return Mapper.funcionarioContainer2FuncionarioListDTO(result);
    }

    public static FuncionarioListDTO getNFuncionariosMaisNovos(int n) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        ArrayList<Funcionario> funcionarios = cabeleireiro.getFuncionarios().getFuncionarios();
        ArrayList<Funcionario> funcionariosMaisVelhos = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            if (funcionariosMaisVelhos.size() < n) {
                funcionariosMaisVelhos.add(funcionario);
                continue;
            }
            for (int i = 0; i < funcionariosMaisVelhos.size(); i++) {
                if (funcionario.getDataNascimento().isLater(funcionariosMaisVelhos.get(i).getDataNascimento())) {
                    funcionariosMaisVelhos.add(i, funcionario);
                    funcionariosMaisVelhos.remove(n);
                    break;
                }
            }
        }
        FuncionarioContainer result = new FuncionarioContainer();
        for (Funcionario funcionario : funcionariosMaisVelhos) {
            result.add(funcionario.getNumFuncionario(), funcionario);
        }
        return Mapper.funcionarioContainer2FuncionarioListDTO(result);
    }

}
