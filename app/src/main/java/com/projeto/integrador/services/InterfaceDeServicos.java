package com.projeto.integrador.services;

import com.projeto.integrador.domain.Fazendas;
import com.projeto.integrador.domain.Usuario;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface InterfaceDeServicos {

    @GET("/usuarios")
    Call<List<Usuario>> obterDados();

    @GET("/fazendas")
    Call<List<Fazendas>> obterFazendas();

    @POST("/usuarios")
    Call<Usuario> cadastrarUsuario(@Body Usuario usuario); // estranho um post que tem retorno.

    @DELETE("/usuarios/{id}")
    Call<Usuario> apagarUsuario(@Path("id") int id);

}
