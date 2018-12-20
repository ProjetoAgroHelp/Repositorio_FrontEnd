package com.projeto.integrador.domain;

import java.io.Serializable;
import java.util.Date;

class Orcamento implements Serializable {

    private Integer id;
    private Double preco;
    private String descricao;
    private Date dataOrcamento;
    private Usuario usuarioOrcamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataOrcamento() {
        return dataOrcamento;
    }

    public void setDataOrcamento(Date dataOrcamento) {
        this.dataOrcamento = dataOrcamento;
    }

    public Usuario getUsuarioOrcamento() {
        return usuarioOrcamento;
    }

    public void setUsuarioOrcamento(Usuario usuarioOrcamento) {
        this.usuarioOrcamento = usuarioOrcamento;
    }

    public Proposta getPropostaOrcamento() {
        return propostaOrcamento;
    }

    public void setPropostaOrcamento(Proposta propostaOrcamento) {
        this.propostaOrcamento = propostaOrcamento;
    }

    private Proposta propostaOrcamento;
}
