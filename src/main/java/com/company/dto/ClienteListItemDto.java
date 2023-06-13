package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"numeroCliente","nome"})
@JacksonXmlRootElement(localName = "cliente")
public class ClienteListItemDto {
        @JacksonXmlProperty(localName =  "numeroCliente")
        private  int numeroCliente;
        @JacksonXmlProperty(localName = "nome")
        private String nome;
       public ClienteListItemDto(){

        }
        public ClienteListItemDto(int numeroCliente, String nome){
            this.nome=nome;
            this.numeroCliente=numeroCliente;
        }

        public int getNumeroCliente() {
            return numeroCliente;
        }

        public void setNumeroCliente(int numeroCliente) {
            this.numeroCliente = numeroCliente;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
}
