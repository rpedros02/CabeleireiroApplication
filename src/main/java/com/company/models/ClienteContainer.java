package com.company.models;

import com.company.exceptions.ElementoNaoExisteException;
import com.company.exceptions.InvalidDateException;

import java.io.Serializable;
import java.util.ArrayList;

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

    public int size(){
        if(this.clientes == null){
            return 0;
        }
        return this.clientes.size();
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
    public Cliente get(int numeroCliente){
         Cliente cliente = search(numeroCliente);
        if(cliente != null){
            return cliente;
        }else{
            String msg = "Student: " + numeroCliente+ " does not exist!!";
            throw  new InvalidDateException(msg);
        }
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
        Cliente cliente= new Cliente(obj.getNome(),obj.getDataNascimento(),obj.getnIF(),obj.getNumeroCliente());
        this.clientes.add(cliente);
    }

    public void update(int numCliente, String nome, Date dataNascimento, int nIF) {
        Cliente cliente = search(numCliente);
        if (cliente != null) {
            cliente.setNome(nome);
            cliente.setDataNascimento(dataNascimento);
            cliente.setnIF(nIF);
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
