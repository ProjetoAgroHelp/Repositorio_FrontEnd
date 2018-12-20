package com.projeto.integrador.domain;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Proposta implements Serializable {

    private Integer id;

    @SerializedName("descrição")
    private String descricao;
    private String prazo;
    private Fazendas fazendaProposta;
    private Usuario propostaFeitaUsuario;
    private List<Orcamento> orcamentos = new ArrayList<>();


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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Fazendas getFazendaProposta() {
        return fazendaProposta;
    }

    public void setFazendaProposta(Fazendas fazendaProposta) {
        this.fazendaProposta = fazendaProposta;
    }

    public Usuario getPropostaFeitaUsuario() {
        return propostaFeitaUsuario;
    }

    public void setPropostaFeitaUsuario(Usuario propostaFeitaUsuario) {
        this.propostaFeitaUsuario = propostaFeitaUsuario;
    }

    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }

    public void setOrcamentos(List<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    }
}
