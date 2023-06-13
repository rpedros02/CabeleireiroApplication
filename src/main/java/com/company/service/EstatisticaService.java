package com.company.service;

import com.company.dto.*;
import com.company.models.*;
import com.company.repository.FilesOperation;

import java.util.ArrayList;

public class EstatisticaService {

    public static ServicoListDto getServicosPorFuncionario(int id) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        ServicosContainer container = new ServicosContainer();
        for (Servico s : cabeleireiro.getServicos().getAll()) {
            if (s.getNumeroFuncionario() == id) {
                container.add(s);
            }
        }
        return Mapper.servicoList2ServicoListDto(container.getAll());
    }


    public static int getNServicosPorFuncionario(int id) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        int count = 0;
        for (Servico s : cabeleireiro.getServicos().getAll()) {
            if (s.getNumeroFuncionario() == id) {
                count++;
            }
        }
        return count;
    }



    public static ClienteListDto getNClientesMaisVelhos(int n) {
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
            result.add(cliente);
        }
        return Mapper.clienteList2ClienteListDto(result.getAll());
    }

    public static ClienteListDto getNClientesMaisNovos(int n) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        ArrayList<Cliente> clientes = cabeleireiro.getClientes().getAll();
        ArrayList<Cliente> clientesMaisNovos = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (clientesMaisNovos.size() < n) {
                clientesMaisNovos.add(cliente);
                continue;
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
            result.add(cliente);
        }
        return Mapper.clienteList2ClienteListDto(result.getAll());
    }

    public static FuncionarioListDto getNFuncionariosMaisVelhos(int n) {
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
            result.add(funcionario);
        }
        return Mapper.funcionarioList2FuncionarioListDto(result.getAll());
    }

    public static FuncionarioListDto getNFuncionariosMaisNovos(int n) {
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
            result.add(funcionario);
        }
        return Mapper.funcionarioList2FuncionarioListDto(result.getAll());
    }

    public static int getNServicosPorCliente(int id) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        int count = 0;
        for (Servico s : cabeleireiro.getServicos().getAll()) {
            if (s.getNumeroCliente() == id) {
                count++;
            }
        }
        return count;
    }

    public static ClienteDto getClienteMaisServicos() {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        int max = 0;
        int idmax = 0;
        for (Cliente c : cabeleireiro.getClientes().getAll()) {
            int count = getNServicosPorCliente(c.getNumeroCliente());
            if (count > max) {
                max = count;
                idmax = c.getNumeroCliente();
            }
        }
        return Mapper.cliente2ClienteDTO(cabeleireiro.getClientes().search(idmax));
    }
    public static FuncionarioDto getFuncionarioMaisServicos() {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        int max = 0;
        int idmax = 0;
        for (Funcionario f : cabeleireiro.getFuncionarios().getAll()) {
            int count = getNServicosPorFuncionario(f.getNumeroFuncionario());
            if (count > max) {
                max = count;
                idmax = f.getNumeroFuncionario();
            }
        }
        return Mapper.funcionario2FuncionarioDTO(cabeleireiro.getFuncionarios().search(idmax));
    }
    public static int nCriticasPorAno(int ano) {
        int count = 0;
        Cabeleireiro cabeleireiro = FilesOperation.load();
        for (Critica c : cabeleireiro.getCriticas().getAll()) {
            if (c.getDataCritica().getYear() == ano) count++;
        }
        return count;
    }

    public static String getAnoMaisCriticas() {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        int maxDate = 0;
        int max = 0;
        String maxi="";
        for (Critica c : cabeleireiro.getCriticas().getAll()) {
            if (nCriticasPorAno(c.getDataCritica().getYear()) > max) {
                maxDate = c.getDataCritica().getYear();
                max = nCriticasPorAno(c.getDataCritica().getYear());
              maxi=String.valueOf(maxDate);
            }
        }
        return maxi;
    }

    public static String getMediaAvaliacoes() {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        double soma = 0;
        String valor="";
        for (Critica c : cabeleireiro.getCriticas().getAll()) {
            soma += c.getAvaliacao();
        }
        valor=String.valueOf(round(soma / cabeleireiro.getCriticas().getAll().size(), 2));
        return valor;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
