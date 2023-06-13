package com.company.models;

import com.company.exceptions.ElementoNaoExisteException;
import com.company.exceptions.InvalidDateException;
import com.company.service.ProdutoService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.springframework.core.annotation.MergedAnnotations.search;

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

    public void setStock(ArrayList<Produto> stock) {
        this.stock = stock;
    }


    public List<Produto> getAll(){
        List<Produto> newlist = new ArrayList();
        newlist.addAll(this.stock);
        return newlist;
    }
    public Produto get(int number){
        Produto produto=search(number);
        if(produto != null){
            return produto;
        }else{
            String msg = "Produto: " + number+ "nao existe!!";
            throw  new InvalidDateException(msg);
        }
    }
    private Produto search(int number) {
        Produto  produto;
        Iterator<Produto> it = this.stock.iterator();
        while(it.hasNext()){
            produto = it.next();
            if(produto.isEqualTo(number)){
                return produto;
            }
        }
        return null;
    }

    public void update(int id, Produto arg) {
        Produto produto = search(id);
        if (produto != null) {
            produto.setNome(arg.getNome());
            produto.setPreco(arg.getPreco());
        } else {
            throw new ElementoNaoExisteException("Servico " + id + " não existe.");
        }
    }

    public void remove(int number) {
        Produto produto = search(number);
        if (produto != null) {
            this.stock.remove(produto);
        } else {
            throw new ElementoNaoExisteException("Erro - Elemento não existe.");
        }
    }
}
