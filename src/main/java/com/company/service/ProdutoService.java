package com.company.service;

import com.company.dto.*;
import com.company.models.Cabeleireiro;
import com.company.models.ProdutoContainer;
import com.company.repository.FilesOperation;

public class ProdutoService {
    public static ProdutoListDTO getProdutos() {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        ProdutoContainer list = cabeleireiro.getProdutos();
        return Mapper.produtoContainer2ProdutoListDTO(list);
    }

    public static ProdutoDTO getProdutoInfo(int id) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        return Mapper.produto2ProdutoDTO(cabeleireiro.getProdutos().getProdutoByID(id));
    }

    public static void addProduto(ProdutoDTO arg){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getProdutos().addProduto(Mapper.produtoDTO2Produto(arg));
        FilesOperation.save(cabeleireiro);
    }

    public static void updateProduto(int id,ProdutoDTO arg){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getProdutos().update(id,Mapper.produtoDTO2Produto(arg));
        FilesOperation.save(cabeleireiro);
    }

    public static void removeProduto(int number){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getProdutos().remove(number);
        FilesOperation.save(cabeleireiro);
    }
}