package com.projeto.integrador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.projeto.integrador.domain.Usuario;
import com.projeto.integrador.services.InterfaceDeServicos;
import com.projeto.integrador.services.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroAcitivity extends DrawerCreator {

    private InterfaceDeServicos interfaceDeServicos;
    private RetrofitService retrofitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null)
            savedInstanceState = new Bundle();
        savedInstanceState.putInt("layout", R.layout.activity_cadastro);
        super.onCreate(savedInstanceState);
    }

    public void cadastrarUsuario(View view){
        EditText tempNome = findViewById(R.id.cadastroNome);
        String nome = tempNome.getText().toString();
        EditText tempSenha = findViewById(R.id.cadastroSenha);
        String senha = tempSenha.getText().toString();
        EditText tempCPF = findViewById(R.id.cadastroCPF);
        String cpf = tempCPF.getText().toString();
        EditText tempEmail = findViewById(R.id.cadastroEmail);
        String email = tempEmail.getText().toString();
        EditText tempLogin = findViewById(R.id.cadastroLogin);
        String login =  tempLogin.getText().toString();

        Usuario usuario = new Usuario(nome, senha,cpf, email, login);

        Call<Usuario> call = interfaceDeServicos.cadastrarUsuario(usuario);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
               if(response.isSuccessful()){
                   int temp = response.code();
                   Log.i("tagCerta", "cadastrou!");
               }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.i("tagCadastro", "falhou tela de cadastro!" + t.getMessage());
            }
        });
    }
}
