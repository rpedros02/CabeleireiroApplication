package com.company.dto;

import com.company.models.*;

import java.util.ArrayList;

public class Mapper {

    public static ProdutoDTO produto2ProdutoDTO(Produto arg) {
        return new ProdutoDTO(arg.getId(), arg.getNome(), arg.getPreco());
    }

    public static Produto produtoDTO2Produto(ProdutoDTO arg) {
        return new Produto(arg.getId(), arg.getNome(), arg.getPreco());
    }

    public static Date dateDTO2Date(DateDTO arg) {
        return new Date(arg.getDay(), arg.getMonth(), arg.getYear());
    }

    public static DateDTO date2DateDTO(Date arg) {
        return new DateDTO(arg.getDay(), arg.getMonth(), arg.getYear());
    }

    public static Critica CriticaDTO2Critica(CriticaDTO arg) {
        Date date = dateDTO2Date(arg.getDataCritica());
        return new Critica(arg.getNumeroCliente(), arg.getAvaliacao(), arg.getTexto(), date);
    }

    public static CriticaDTO critica2CriticaDTO(Critica arg) {
        return new CriticaDTO(arg.getCliente().getNumeroCliente(), arg.getAvaliacao(), arg.getTexto(), date2DateDTO(arg.getDataCritica()));
    }

    public static HorarioDTO horario2HorarioDTO(Horario arg) {
        return new HorarioDTO(arg.getHoraAbertura(), arg.getMinutosAbertura(), arg.getHoraFecho(), arg.getMinutosFecho());
    }

    public static Horario horarioDTO2Horario(HorarioDTO arg) {
        return new Horario(arg.getHoraAbertura(), arg.getMinutoAbertura(), arg.getHoraFecho(), arg.getMinutoFecho());
    }

    public static CabeleireiroDTO cabeleireiro2CabeleireiroDTO(Cabeleireiro arg) {
        return new CabeleireiroDTO(arg.getNome(), arg.getMorada(), arg.getSaldo(), arg.getNumCadeirasLavagem(), arg.getNumCadeirasBrushing(),horario2HorarioDTO(arg.getHorario()));
    }

    public static Cabeleireiro cabeleireiroDTO2Cabeleireiro(CabeleireiroDTO arg) {
        return new Cabeleireiro(arg.getNome(), arg.getMorada(), arg.getSaldo(), arg.getNumCadeirasLavagem(), arg.getNumCadeirasBrushing(),horarioDTO2Horario(arg.getHorario()));
    }

    public static HorarioServicoDTO horarioServico2HorarioServicoDTO(HorarioServico arg) {
        return new HorarioServicoDTO(arg.getHora(), arg.getMinutos());
    }

    public static HorarioServico horarioServicoDTO2HorarioServico(HorarioServicoDTO arg) {
        return new HorarioServico(arg.getHora(), arg.getMinuto());
    }

    public static ServicoDTO servico2ServicoDTO(Servico arg) {
        return new ServicoDTO(arg.getNumPedido(),arg.getNumCliente(), date2DateDTO(arg.getDataServico()), horarioServico2HorarioServicoDTO(arg.getHorarioServico()));
    }

    public static Servico servicodto2Servico(ServicoDTO arg) {
        return new Servico(arg.getNumPedido(), arg.getNumCliente(), dateDTO2Date(arg.getDataServico()), horarioServicoDTO2HorarioServico(arg.getHorarioServico()));
    }

    public static ServicoListDTO servicoList2ServicoListDTO(ServicosContainer arg) {
        ArrayList<ServicoDTO> temp = new ArrayList<>();
        for (Servico s : arg.getServicos()) {
            temp.add(servico2ServicoDTO(s));
        }
        return new ServicoListDTO(temp);
    }

    public static ServicosContainer servicoListDTO2ServicosList(ServicoListDTO arg) {
        ArrayList<Servico> temp = new ArrayList<>();
        for (ServicoDTO s : arg.getServicos()) {
            temp.add(servicodto2Servico(s));
        }
        return new ServicosContainer(temp);
    }

    public static PessoaDTO pessoa2PessoaDTO(Pessoa arg) {
        return new PessoaDTO(arg.getNome(), date2DateDTO(arg.getDataNascimento()), arg.getnIF(), arg.getGenero().toString());
    }

    public static Pessoa pessoaDTO2Pessoa(PessoaDTO arg) {
        return new Pessoa(arg.getNome(), dateDTO2Date(arg.getDataNascimento()), arg.getnIF(), arg.getGenero());
    }

    public static ClienteDTO cliente2ClienteDTO(Cliente arg) {
        return new ClienteDTO(arg.getNumeroCliente(), arg.getNome(),Mapper.date2DateDTO(arg.getDataNascimento()), arg.getnIF(), arg.getGenero().toString());
    }

    public static Cliente clienteDTO2Cliente(ClienteDTO arg) {
        return new Cliente(arg.getNome(),Mapper.dateDTO2Date(arg.getDataNascimento()),arg.getNif(), arg.getGenero(),arg.getNumeroCliente());
    }

    public static FuncionarioDTO funcionario2FuncionarioDTO (Funcionario arg){
        return new FuncionarioDTO(arg.getNumFuncionario(), arg.getNome());
    }

    public static Funcionario funcionarioDTO2Funcionario(FuncionarioDTO arg){
        return new Funcionario(arg.getNumeroFuncionario(), arg.getNome());
    }

    public static ClienteListDTO clienteContainer2ClienteListDTO(ClienteContainer arg) {
        ArrayList<ClienteDTO> temp = new ArrayList<>();
        for (Cliente c : arg.getAll()) {
            temp.add(cliente2ClienteDTO(c));
        }
        return new ClienteListDTO(temp);
    }

    public static ClienteContainer clienteListDTO2ClientesContainer(ClienteListDTO arg) {
        ArrayList<Cliente> temp = new ArrayList<>();
        for (ClienteDTO c : arg.getClientes()) {
            temp.add(clienteDTO2Cliente(c));
        }
        return new ClienteContainer(temp);
    }

    public static FuncionarioListDTO funcionarioContainer2FuncionarioListDTO(FuncionarioContainer arg) {
        ArrayList<FuncionarioDTO> temp = new ArrayList<>();
        for (Funcionario f : arg.getFuncionarios()) {
            temp.add(funcionario2FuncionarioDTO(f));
        }
        return new FuncionarioListDTO(temp);
    }

    public static FuncionarioContainer funcionarioListDTO2FuncionarioContainer(FuncionarioListDTO arg) {
        ArrayList<Funcionario> temp = new ArrayList<>();
        for (FuncionarioDTO f : arg.getFuncionarios()) {
            temp.add(funcionarioDTO2Funcionario(f));
        }
        return new FuncionarioContainer(temp);
    }
}
