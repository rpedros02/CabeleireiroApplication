package com.company.service;

import com.company.dto.*;
import com.company.models.Cabeleireiro;
import com.company.models.Produto;
import com.company.models.ProdutoContainer;
import com.company.repository.FilesOperation;

import java.util.List;

public class ProdutoService {
    public static ProdutoListDto getProdutos() {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        List<Produto> list = cabeleireiro.getProdutos().getAll();
        ProdutoListDto result = Mapper.produtoList2ProdutoListDto(list);
        return result;
    }

    public static ProdutoDto getProdutoInfo(int id) {
        Cabeleireiro cabeleireiro = FilesOperation.load();
        Produto item = cabeleireiro.getProdutos().get(id);
        ProdutoDto result = Mapper.produto2ProdutoDTO(item);
        return result;
    }

    public static void addProduto(ProdutoDto arg){
        Cabeleireiro cabeleireiro = FilesOperation.load();
        cabeleireiro.getProdutos().addProduto(Mapper.produtoDTO2Produto(arg));
        FilesOperation.save(cabeleireiro);
    }

    public static void updateProduto(int id, ProdutoDto arg){
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