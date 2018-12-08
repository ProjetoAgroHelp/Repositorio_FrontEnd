package com.projeto.integrador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.projeto.integrador.domain.Proposta;
import com.projeto.integrador.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropostaActivity extends DrawerCreator {
    private RetrofitService retrofitService;
    private String mensagem;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null)
            savedInstanceState = new Bundle();
        savedInstanceState.putInt("layout", R.layout.activity_proposta);
        super.onCreate(savedInstanceState);
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_proposta);
//    }

    public void cadastrarProposta(View view){
        EditText campoDescricao = findViewById(R.id.descri);
        String descricao = campoDescricao.getText().toString();

        EditText campoPrazo = findViewById(R.id.prazo);
        String prazo = campoPrazo.getText().toString();

        Proposta proposta = new Proposta(descricao,prazo);

        Call call = retrofitService.getServico().cadastraProposta(proposta);
        call.enqueue(new Callback<Proposta>() {
            @Override
            public void onResponse(Call<Proposta> call, Response<Proposta> response) {
                Log.i("teste","Entrou Post!");
                Toast.makeText(getApplicationContext(), "proposta criada com sucesso", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PropostaActivity.this, FeedActivity.class);
                intent.putExtra("mensagem", mensagem);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<Proposta> call, Throwable t) {
                //Toast.makeText(PropostaActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
