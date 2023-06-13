package com.company.dto;


import com.company.models.*;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static ProdutoDto produto2ProdutoDTO(Produto arg) {
        return new ProdutoDto(arg.getId(), arg.getNome(), arg.getPreco());
    }

    public static Produto produtoDTO2Produto(ProdutoDto arg) {
        return new Produto(arg.getId(), arg.getNome(), arg.getPreco());
    }

    public static Date dateDTO2Date(DateDto arg) {
        return new Date(arg.getDay(), arg.getMonth(), arg.getYear());
    }

    public static DateDto date2DateDTO(Date arg) {
        return new DateDto(arg.getDay(), arg.getMonth(), arg.getYear());
    }

    public static Critica criticaDTO2Critica(CriticaDto arg) {
        Date date = dateDTO2Date(arg.getDataCritica());
        return new Critica(arg.getNumeroCliente(), arg.getAvaliacao(), arg.getTexto(), date);
    }

    public static CriticaDto critica2CriticaDTO(Critica arg) {
        return new CriticaDto(arg.getCliente(), arg.getAvaliacao(), arg.getTexto(), date2DateDTO(arg.getDataCritica()));
    }

    public static HorarioDto horario2HorarioDTO(Horario arg) {
        return new HorarioDto(arg.getHoraAbertura(), arg.getMinutosAbertura(), arg.getHoraFecho(), arg.getMinutosFecho());
    }

    public static Horario horarioDTO2Horario(HorarioDto arg) {
        return new Horario(arg.getHoraAbertura(), arg.getMinutoAbertura(), arg.getHoraFecho(), arg.getMinutoFecho());
    }

    public static CabeleireiroDto cabeleireiro2CabeleireiroDTO(String arg) {
        CabeleireiroDto obj = new CabeleireiroDto(arg);
        return obj;
    }

    public static HorarioServicoDto horarioServico2HorarioServicoDTO(HorarioServico arg) {
        return new HorarioServicoDto(arg.getHora(), arg.getMinutos());
    }

    public static HorarioServico horarioServicoDTO2HorarioServico(HorarioServicoDto arg) {
        return new HorarioServico(arg.getHora(), arg.getMinuto());
    }
    public static Servico servicoDto2Servico (ServicoDto arg){
        Date date = dateDTO2Date(arg.getDataServico());
        HorarioServico horarioServico = horarioServicoDTO2HorarioServico(arg.getHorarioServico());
        Servico obj= new Servico(arg.getNumeroPedido(),arg.getNumeroCliente(),arg.getNumeroFuncionario(),date,horarioServico);
        return obj;
    }
    public static ServicoDto servico2ServicoDTO(Servico arg) {
        DateDto dateDto = date2DateDTO(arg.getDataServico());
        HorarioServicoDto horarioServicoDto = horarioServico2HorarioServicoDTO(arg.getHorarioServico());
        return new ServicoDto(arg.getNumeroPedido(),arg.getNumeroCliente(),arg.getNumeroFuncionario(),dateDto, horarioServicoDto);
    }

    public static ServicoListItemDto servico2ServicoListItemDto(Servico arg){
        ServicoListItemDto  obj = new ServicoListItemDto(arg.getNumeroPedido(),arg.getNumeroFuncionario());
        return obj;
    }
    public static ServicoListDto servicoList2ServicoListDto(List<Servico> arg){
        ArrayList<ServicoListItemDto> list = new ArrayList<>();
        for(Servico p : arg){
            ServicoListItemDto item = servico2ServicoListItemDto(p);
            list.add(item);
        }
        ServicoListDto  obj = new ServicoListDto(list);
        return obj;
    }
    public static ClienteDto cliente2ClienteDTO(Cliente arg) {
        return new ClienteDto(arg.getNumeroCliente(), arg.getNome(), Mapper.date2DateDTO(arg.getDataNascimento()), arg.getnIF());
    }

    public static Cliente clienteDTO2Cliente(ClienteDto arg) {
        return new Cliente(arg.getNome(), Mapper.dateDTO2Date(arg.getDataNascimento()), arg.getNif(), arg.getNumeroCliente());
    }

    public static FuncionarioDto funcionario2FuncionarioDTO(Funcionario arg) {
        DateDto dateDTO = date2DateDTO(arg.getDataNascimento());
        return new FuncionarioDto(arg.getNumeroFuncionario(),arg.getNome(),dateDTO,arg.getnIF());
    }

    public static Funcionario funcionarioDTO2Funcionario(FuncionarioDto arg) {
        return new Funcionario(arg.getNome(), Mapper.dateDTO2Date(arg.getDataNascimento()), arg.getNif(), arg.getNumeroFuncionario());
    }
    public static ClienteListItemDto cliente2ClienteListItemDto(Cliente arg){
        //DateDto date = date2DateDTO(arg.getDataNascimento());
       ClienteListItemDto  obj = new ClienteListItemDto(arg.getNumeroCliente(),arg.getNome());
        return obj;
    }
    public static ClienteListDto clienteList2ClienteListDto(List<Cliente> arg) {
        ArrayList<ClienteListItemDto> list = new ArrayList<>();
        for (Cliente c : arg) {
            ClienteListItemDto item =cliente2ClienteListItemDto(c);
            list.add(item);
        }
        ClienteListDto obj = new ClienteListDto(list);
        return obj;
    }
    public static FuncionarioListItemDto funcionario2FuncionarioListItemDto(Funcionario arg){
        DateDto date = date2DateDTO(arg.getDataNascimento());
        FuncionarioListItemDto  obj = new FuncionarioListItemDto(arg.getNumeroFuncionario(),arg.getNome());
        return obj;
    }
    public static FuncionarioListDto funcionarioList2FuncionarioListDto(List<Funcionario> arg) {
        ArrayList<FuncionarioListItemDto> list = new ArrayList<>();
        for (Funcionario c : arg) {
            FuncionarioListItemDto item =funcionario2FuncionarioListItemDto(c);
            list.add(item);
        }
        FuncionarioListDto obj = new FuncionarioListDto(list);
        return obj;
    }


    public static ProdutoListItemDto produto2ProdutoListItemDto(Produto arg){
        ProdutoListItemDto  obj = new ProdutoListItemDto(arg.getId(),arg.getNome());
        return obj;
    }
    public static ProdutoListDto produtoList2ProdutoListDto(List<Produto> arg){
        ArrayList<ProdutoListItemDto> list = new ArrayList<>();
        for(Produto p : arg){
            ProdutoListItemDto item = produto2ProdutoListItemDto(p);
            list.add(item);
        }
        ProdutoListDto  obj = new ProdutoListDto(list);
        return obj;
    }
    public static CriticaListItemDto critica2CriticaListItemDto(Critica arg){
        CriticaListItemDto  obj = new CriticaListItemDto(arg.getCliente(),arg.getAvaliacao());
        return obj;
    }

    public static CriticaListDto criticaList2CriticaListDto(List<Critica> arg){
        ArrayList<CriticaListItemDto> list = new ArrayList<>();
        for(Critica p : arg){
            CriticaListItemDto item =critica2CriticaListItemDto (p);
            list.add(item);
        }
        CriticaListDto  obj = new CriticaListDto(list);
        return obj;
    }


}
