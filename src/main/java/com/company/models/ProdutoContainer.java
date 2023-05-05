package com.company.models;

import com.company.exceptions.ElementoNaoExisteException;
import com.company.service.ProdutoService;

import java.io.Serializable;
import java.util.ArrayList;

public class ProdutoContainer implements Serializable {
    private ArrayList<Produto> stock;

    public ProdutoContainer(ArrayList<Produto> stock) {
        this.stock = stock;
    }

    public ProdutoContainer() {
        this.stock = new ArrayList<>();
    }

    private int getNewNumber() {
        int num = 0;
        for (int i = stock.size() - 1; i >= 0; i--) {
            if (stock.get(i).getId() > num) {
                num = stock.get(i).getId();
            }
        }
        return (num + 1);
    }

    public void addProduto(Produto produto) {
        stock.add(new Produto(getNewNumber(), produto.getNome(), produto.getPreco()));
    }

    public ArrayList<Produto> getStock() {
        return stock;
    }

    public void setStock(ArrayList<Produto> stock) {
        this.stock = stock;
    }

    public Produto getProdutoByID(int id) {
        for (Produto produto : stock) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        throw new ElementoNaoExisteException("Protudo " + id + " não existe");
    }

    public Produto getProdutoByName(String name) {
        for (Produto produto : stock) {
            if (produto.getNome().equals(name)) {
                return produto;
            }
        }
        throw new ElementoNaoExisteException("Protudo " + name + " não existe");
    }

    public void update(int id, Produto arg) {
        Produto produto = getProdutoByID(id);
        if (produto != null) {
            produto.setNome(arg.getNome());
            produto.setPreco(arg.getPreco());
        } else {
            throw new ElementoNaoExisteException("Servico " + id + " não existe.");
        }
    }

    public void remove(int number) {
        Produto produto = getProdutoByID(number);
        if (produto != null) {
            this.stock.remove(produto);
        } else {
            throw new ElementoNaoExisteException("Erro - Elemento não existe.");
        }
    }
}
