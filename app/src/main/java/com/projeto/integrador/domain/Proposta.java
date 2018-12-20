package com.projeto.integrador.domain;


import java.io.Serializable;

public class Proposta implements Serializable {

    private String descricao;
    private String prazo;


    public Proposta(String descricao, String prazo) {
        this.descricao = descricao;
        this.prazo = prazo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }
}
