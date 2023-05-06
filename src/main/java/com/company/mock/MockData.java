package com.company.mock;

import com.company.enums.*;
import com.company.models.*;
import com.company.repository.FilesOperation;
import java.time.Year;
import java.util.concurrent.ThreadLocalRandom;


public class MockData {

    private final int NUM_INICIAL_CLIENTES = 20;
    private final int NUM_INICIAL_SERVICOS = 15;
    private final int NUM_INICIAL_PRODUTOS = 10;
    private final int NUM_INICIAL_CRITICAS = 19;

    private final int NUM_INICIAL_FUNCIONARIOS = 6;
    private int[] numerosFuncionarios = {1111, 2222, 3333, 4444, 5555, 6666};
    private String[] nomes = {"António", "Marta", "Rita", "Tomás", "Ana", "Gustavo", "Renata", "Catarina", "Joana", "Margarida", "Maria", "Mariana", "Pedro", "João", "Dínis", "Diogo", "José", "Rodrigo", "Guilherme"};
    private String[] apelidos = {"Silva", "Pinto", "Castro", "Carvalho", "Horta", "Marques", "Ortiz", "Conceição", "Figueiredo", "Besteiro", "Pereira", "Lopes", "Salvador", "Rodrigues", "Alves"};
    private String[] produtos = {"Shampoo Cabelo Liso", "Shampoo Cabelo Encaracolado", "Shampoo Cabelo Crespo", "Amaciador Cabelo Seco", "Cera FIXtudo", "Amaciador Cabelo Olesoso", "Amaciador Cabelo Misto","Desembaraçador","Protetor Térmico"};

    private String genName() {
        return nomes[genRandomInt(0, nomes.length)] + " " + apelidos[genRandomInt(0, apelidos.length)];
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    private String genNameProduto() {
        return produtos[genRandomInt(0, produtos.length)];
    }

    private Genero genGenero(String nome) {
        String[] split = nome.split(" ");
        if (split[0].charAt(split[0].length() - 1) == 'a') {
            return Genero.FEMININO;
        } else if (split[0].charAt(split[0].length() - 1) == 'o') {
            return Genero.MASCULINO;
        } else {
            return Genero.NAOBINARIO;
        }
    }

    private Date genDate() {
        int day = genRandomInt(1, 27);
        int month = genRandomInt(1, 12);
        int year = genRandomInt(1970, 2005);
        return new Date(day, month, year);
    }

    private void insertClientes(ClienteContainer container) {
        for (int i = 0; i <= NUM_INICIAL_CLIENTES; i++) {
            String nome = genName();
            container.add(new Cliente(nome, genDate(), 999999999, genGenero(nome), i + 1));
        }
    }

    private void insertFuncionarios(FuncionarioContainer container) {
        for (int i = 0; i < NUM_INICIAL_FUNCIONARIOS; i++) {
            String nome = genName();
            container.addFuncionario(new Funcionario(nome, genDate(), 999999999, genGenero(nome), numerosFuncionarios[i]));
        }
    }

    private int genRandomInt(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    private double genRandomDouble(double origin, double bound) {
        return ThreadLocalRandom.current().nextDouble(origin, bound);
    }

    private void insertServicos(ServicosContainer container) {
        for (int i = 0; i <= NUM_INICIAL_SERVICOS; i++) {
            ProdutoContainer container1 = new ProdutoContainer();
            insertProdutosInServicos(container1,genRandomInt(0,11));
            container.add(new Servico(i + 1, (long) genRandomInt(1, 20), numerosFuncionarios[genRandomInt(0, numerosFuncionarios.length)], genDate(), new HorarioServico(genRandomInt(6, 12), genRandomInt(14, 21)), false, container1));
        }
    }

    private ProdutoContainer insertProdutosInServicos(ProdutoContainer container,int num) {
        for (int i = 0; i <= num; i++) {
            container.addProduto(new Produto(i + 1, genNameProduto(), round(genRandomDouble(0.0, 49.99), 2)));
        }
        return container;
    }
    private void insertProdutos(ProdutoContainer container) {
        for (int i = 0; i <= NUM_INICIAL_PRODUTOS; i++) {
            container.addProduto(new Produto(i + 1, genNameProduto(), round(genRandomDouble(0.0, 49.99), 2)));
        }
    }

    private void insertCritica(CriticaContainer container){
        for(int i = 0; i <=NUM_INICIAL_CRITICAS; i++){
            String mock = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut lorem sem, auctor sit amet magna eget, sagittis hendrerit nibh. Quisque eget tempus metus. Duis egestas finibus felis in sodales. Donec ut ante faucibus, placerat turpis et, sodales risus. Proin et augue eget quam consectetur consectetur. Quisque dictum, sapien quis gravida sodales, odio sapien condimentum ipsum, ut sollicitudin purus turpis aliquam ante. Ut pulvinar auctor lacus a euismod. Sed ante leo, aliquam convallis lectus at, porta. ";
            container.add(new Critica(genRandomInt(1,NUM_INICIAL_CLIENTES),genRandomInt(0,10),mock,genDate()));
        }
    }

    private Horario genHorario() {
        return new Horario(genRandomInt(6, 11), genRandomInt(0, 50), genRandomInt(14, 21), genRandomInt(0, 50));
    }

    public void generateData(Cabeleireiro cabeleireiro) {
        cabeleireiro.setHorario(genHorario());
        insertClientes(cabeleireiro.getClientes());
        insertFuncionarios(cabeleireiro.getFuncionarios());
        insertServicos(cabeleireiro.getServicos());
        insertProdutos(cabeleireiro.getProdutos());
        insertCritica(cabeleireiro.getCriticas());
    }
}
