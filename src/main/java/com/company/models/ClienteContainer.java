package com.company.models;

import com.company.enums.Genero;
import com.company.exceptions.ElementoNaoExisteException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ClienteContainer implements Serializable {
    private ArrayList<Cliente> clientes;

    public ClienteContainer() {
        this.clientes = new ArrayList<>();
    }

    public ClienteContainer(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Cliente> getAll() {
        return new ArrayList<>(this.clientes);
    }

    public Cliente search(int id) {
        Cliente cliente;
        for (Cliente value : this.clientes) {
            cliente = value;
            if (cliente.getNumeroCliente() == id) {
                return cliente;
            }
        }
        return null;
    }

    private long getNewNumber() {
        long num = 0;
        for (int i = clientes.size() - 1; i >= 0; i--) {
            if (clientes.get(i).getNumeroCliente() > num) {
                num = clientes.get(i).getNumeroCliente();
            }
        }
        return (num + 1);
    }

    public void add(Cliente obj) {
        this.clientes.add(new Cliente(obj.getNome(), obj.getDataNascimento(), obj.getnIF(), obj.getGenero(), getNewNumber()));
    }

    public void add(long numCliente, Cliente obj) {
        this.clientes.add(new Cliente(obj.getNome(), obj.getDataNascimento(), obj.getnIF(), obj.getGenero(), numCliente));
    }

    public void update(int numCliente, String nome, Date dataNascimento, int nIF, String genero) {
        Cliente cliente = search(numCliente);
        if (cliente != null) {
            cliente.setNome(nome);
            cliente.setDataNascimento(dataNascimento);
            cliente.setnIF(nIF);
            if (genero.equalsIgnoreCase("masculino")) {
                cliente.setGenero(Genero.MASCULINO);
            } else if (genero.equalsIgnoreCase("feminino")) {
                cliente.setGenero(Genero.FEMININO);
            } else {
                cliente.setGenero(Genero.NAOBINARIO);
            }
        } else {
            throw new ElementoNaoExisteException("Cliente " + numCliente + " não existe.");
        }
    }

    public void remove(int number) {
        Cliente cliente = search(number);
        if (cliente != null) {
            this.clientes.remove(cliente);
        } else {
            throw new ElementoNaoExisteException("Erro.");
        }
    }
}
