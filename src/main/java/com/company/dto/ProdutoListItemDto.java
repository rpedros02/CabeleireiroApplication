package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JsonPropertyOrder({"id", "nome"})
@JacksonXmlRootElement(localName = "produto")
public class ProdutoListItemDto {
    @JacksonXmlProperty(localName = "id")
    private int id;
    @JacksonXmlProperty(localName = "nome")
    private String nome;

    public ProdutoListItemDto() {
    }

    public ProdutoListItemDto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
