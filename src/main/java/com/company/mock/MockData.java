package com.company.mock;
import com.company.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class MockData {

    private final int NUM_INICIAL_CLIENTES = 20;
    private final int NUM_INICIAL_SERVICOS = 15;
    private final int NUM_INICIAL_PRODUTOS = 10;
    private final int NUM_INICIAL_CRITICAS = 19;
    private final int NUM_INICIAL_NIF=22;

    private final int NUM_INICIAL_FUNCIONARIOS = 6;
    private  int[] numerosFuncionarios = {1111, 2222,3333,4444,5555,6666};
    private int[] nifClientes={117654321,106352412,197656545,184354657,187362514,126756452,175213447,166009655,175342312,164231223,178675645,112233445,112231223,168400123,172341919,185179900,100000453,100034561,10132445,145121210,113456781,113299876};
    private String[] nomes = {"António", "Marta", "Rita", "Tomás", "Ana", "Gustavo", "Renata", "Catarina", "Joana", "Margarida", "Maria", "Mariana", "Pedro", "João", "Dínis", "Diogo", "José", "Rodrigo", "Guilherme"};
    private String[] apelidos = {"Silva", "Pinto", "Castro", "Carvalho", "Horta", "Marques", "Ortiz", "Conceição", "Figueiredo", "Besteiro", "Pereira", "Lopes", "Salvador", "Rodrigues", "Alves"};
    private String[] produtos = {"Shampoo Cabelo Liso", "Shampoo Cabelo Encaracolado", "Shampoo Cabelo Crespo", "Amaciador Cabelo Seco", "Cera FIXtudo", "Amaciador Cabelo Olesoso", "Amaciador Cabelo Misto","Desembaraçador","Protetor Térmico","Amaciador dois em 1"};
    private int[] minutosServico = {15,20,25,30,35,40,45,50,55};
    private int[] horaServico = {9,10,11,12,13,14,15,16,17,18,19,20};


    private String genNome() {
        return nomes[genRandomInt(0, nomes.length)] + " " + apelidos[genRandomInt(0, apelidos.length)];
    }
    private int genNif(){
        return nifClientes[genRandomInt(0,nifClientes.length)];
    }
    private int genHoraServico(){
        return horaServico[genRandomInt(0,horaServico.length)];
    }
    private int genMinutosServico(){
        return minutosServico[genRandomInt(0,minutosServico.length)];
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
    private int genNumeroFuncionario() {
        return numerosFuncionarios[genRandomInt(0, numerosFuncionarios.length)];
    }
    private Date genDate() {
        int day = genRandomInt(1, 27);
        int month = genRandomInt(1, 12);
        int year = genRandomInt(1970, 2005);
        return new Date(day, month, year);
    }

    private HorarioServico genHorarioServico() {
        int hora = genHoraServico();
        int minutos = genMinutosServico();
        return new HorarioServico(hora,minutos);
    }
    private void insertClientes(ClienteContainer container) {
        for (int i = 0; i <= NUM_INICIAL_CLIENTES; i++) {
            Date dt = genDate();
            String nome = genNome();
            int nif=genNif();
            Cliente obj = new Cliente(nome, dt, nif, i + 1);
            container.add(obj);
        }
    }

    private void insertFuncionarios(FuncionarioContainer container) {
        for (int i = 0; i < NUM_INICIAL_FUNCIONARIOS; i++) {
            String nome = genNome();
            Date dt= genDate();
            int nif=genNif();
            int numero=genNumeroFuncionario();
            Funcionario obj;
            obj = new Funcionario(nome, dt, nif, numero);
            container.add(obj);
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
            container.add(new Servico(i + 1, genRandomInt(1, 20), numerosFuncionarios[genRandomInt(0, numerosFuncionarios.length)], genDate(),genHorarioServico()));
        }
    }
    private void insertProdutos(ProdutoContainer container) {
        for (int i = 0; i <= NUM_INICIAL_PRODUTOS; i++) {
            container.addProduto(new Produto(i + 1, genNameProduto(), round(genRandomDouble(0.0, 49.99), 2)));
        }
    }

    private void insertCritica(CriticaContainer container){
        for(int i = 0; i <=NUM_INICIAL_CRITICAS; i++){
            String mock = "Fui atendido por um cabeleireiro talentoso e habilidoso, que demonstrou um conhecimento profundo sobre cortes de cabelo e estilos atualizado.O serviço em si foi excepcional.Ele trabalhou com precisão e cuidado, garantindo que cada mecha de cabelo fosse tratada com atenção. Além disso, ele explicou cada etapa do processo, oferecendo conselhos úteis sobre como cuidar melhor do meu cabelo e sugerindo produtos que poderiam ajudar.\n" +
                    "Eles ofereceram bebidas e revistas para tornar a experiência mais agradável.Ao final do serviço, fiquei maravilhado com o resultado. O cabeleireiro conseguiu transformar minha ideia inicial em um corte de cabelo deslumbrante que combinava perfeitamente com minha personalidade e estilo. Fiquei extremamente satisfeito com o resultado final e recebi muitos elogios de amigos e familiares. ";
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
