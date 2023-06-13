package com.company.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "produtos")
public class ProdutoListDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "produto")
    private ArrayList<ProdutoListItemDto> produtos;
    public ProdutoListDto(){

    }

    public ProdutoListDto(ArrayList<ProdutoListItemDto> produtos) {
        this.produtos = produtos;
    }


    public ArrayList<ProdutoListItemDto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<ProdutoListItemDto> produtos) {
        this.produtos = produtos;
    }
}
