package com.projeto.integrador.services;

import com.projeto.integrador.domain.Fazendas;
import com.projeto.integrador.domain.Proposta;
import com.projeto.integrador.domain.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface InterfaceDeServicos {

    @GET("/usuarios")
    Call<List<Usuario>> obterDados();

    @POST("/usuarios")
    Call<Usuario> logar(String login, String senha);

    @GET("/fazendas")
    Call<List<Fazendas>> obterFazendas();

    @POST("/usuarios")
    Call<Void> cadastrarUsuario(@Body Usuario usuario); // post sem retorno

    @POST("/propostas")
    Call<Void> cadastraProposta(@Body Proposta proposta); // post sem retorno

    @DELETE("/usuarios/{id}")
    Call<Usuario> apagarUsuario(@Path("id") int id);

}
