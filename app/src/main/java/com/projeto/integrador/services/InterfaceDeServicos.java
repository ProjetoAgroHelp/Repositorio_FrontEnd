package com.projeto.integrador.services;

import com.projeto.integrador.domain.Fazendas;
import com.projeto.integrador.domain.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceDeServicos {

    @GET("/usuarios")
    Call<List<Usuario>> obterDados();

    @GET("/fazendas")
    Call<List<Fazendas>> obterFazendas();
}
