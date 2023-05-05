package com.company.dto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
@JsonPropertyOrder({"nome","dataNascimento","nif","genero"})
@JacksonXmlRootElement(localName = "pessoa")
public class PessoaDTO {
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "dataNascimento")
    private DateDTO dataNascimento;
    @JacksonXmlProperty(localName = "nif")
    private int nIF;
    @JacksonXmlProperty(localName = "genero")
    private String genero;

    public PessoaDTO(String nome, DateDTO dataNascimento, int nIF, String genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nIF = nIF;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public DateDTO getDataNascimento() {
        return dataNascimento;
    }

    public int getnIF() {
        return nIF;
    }

    public String getGenero() {
        return genero;
    }
}
