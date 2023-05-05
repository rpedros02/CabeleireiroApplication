package com.company.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "produtos")
public class ProdutoListDTO {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "produto")
    private ArrayList<ProdutoDTO> produtos;

    public ProdutoListDTO(ArrayList<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }


    public ArrayList<ProdutoDTO> getProdutos() {
        return produtos;
    }
}
