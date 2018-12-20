package com.projeto.integrador;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.projeto.integrador.domain.Usuario;
import com.projeto.integrador.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroAcitivity extends AppCompatActivity {

    private RetrofitService retrofitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.tela_cadastro);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);
    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        if (savedInstanceState == null)
//            savedInstanceState = new Bundle();
//        savedInstanceState.putInt("layout", R.layout.activity_cadastro);
//        super.onCreate(savedInstanceState);
//    }

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

        Call call = retrofitService.getServico().cadastrarUsuario(usuario);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Log.i("teste","Entrou Post!");
                Intent i = new Intent(CadastroAcitivity.this, MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(CadastroAcitivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void retornarMain(View view) {
        Intent i = new Intent(CadastroAcitivity.this, MainActivity.class);
        startActivity(i);
    }


}
