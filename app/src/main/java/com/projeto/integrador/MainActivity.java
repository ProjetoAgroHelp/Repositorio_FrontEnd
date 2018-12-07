package com.projeto.integrador;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.projeto.integrador.adapters.UsuarioAdapter;
import com.projeto.integrador.domain.Usuario;
import com.projeto.integrador.services.InterfaceDeServicos;
import com.projeto.integrador.services.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private InterfaceDeServicos interfaceDeServicos;
    private RetrofitService retrofitService;
    private UsuarioAdapter usuarioAdapter;
    private List<Usuario> usuarios;
    private TextView login, senha;
    private String mensagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void irCadastro(View view){
        Intent intent = new Intent(MainActivity.this, CadastroAcitivity.class);
        intent.putExtra("mensagem", mensagem);
        startActivity(intent);

    }


    private void chamada() {
        interfaceDeServicos = retrofitService.getServico();
        Call<List<Usuario>> call = interfaceDeServicos.obterDados();

        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                usuarios = response.body();

                login = findViewById(R.id.loginId);
                senha = findViewById(R.id.senhaId);

                boolean flag = true;

                String loginTexto = login.getText().toString();
                String senhaTexto = senha.getText().toString();

                for(Usuario u : usuarios){
                    if(u.getNome().equals(loginTexto) && u.getSenha().equals(senhaTexto)){
                        flag = false;
                        Intent i = new Intent(MainActivity.this, FeedActivity.class);
                        i.putExtra("usuarioObj", u);
                        Log.i("logou", "Logou galera");
                        startActivity(i);
                    }
                    Log.i("nomes", u.getNome());
                }

                if(flag) {
                    Toast.makeText(getApplicationContext(), "Sistema não reconhece este login e senha", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Log.i("erro", "ocorreu um erro!");
            }
        });

    }

    public void entraNoSistema(View view) {  // botão principal de login do sistema

        login = findViewById(R.id.loginId);
        senha = findViewById(R.id.senhaId);


        Log.i("login", login.getText().toString());

        if((login.getText().toString().isEmpty()) || senha.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Você deve preencher os campos", Toast.LENGTH_SHORT).show();
        }
        else {

            chamada();

        }

        // criei este teste para simplismente buscar os dados digitados na tela e transcrever para o log.
        login = findViewById(R.id.loginId);
        senha = findViewById(R.id.senhaId);



        if (login != null && senha != null){

            String loginTexto = login.getText().toString();
            String senhaTexto = senha.getText().toString();

            Log.i("nome entrado no login", loginTexto);
            Log.i("nome entrado na senha", senhaTexto);
        }


    }
}
