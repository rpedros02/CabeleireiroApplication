package com.company.models;

import com.company.exceptions.ElementoNaoExisteException;

import java.io.Serializable;
import java.util.ArrayList;

public class ProdutoList implements Serializable {
    private ArrayList<Produto> stock;

    public ProdutoList(ArrayList<Produto> stock) {
        this.stock = stock;
    }

    public ProdutoList() {
        this.stock = new ArrayList<>();
    }

    public void addProduto(Produto produto){
        stock.add(produto);
    }
    public void removeProduto(int id){
        stock.removeIf(produto -> produto.getId() == id);
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

    public Produto getProdutoByName(String nome) {
        for (Produto produto : stock) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        throw new ElementoNaoExisteException("Protudo " + nome + " não existe");
    }
}
