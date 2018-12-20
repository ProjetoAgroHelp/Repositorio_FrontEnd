package com.projeto.integrador;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.projeto.integrador.application.AgroHelpApplication;
import com.projeto.integrador.domain.Usuario;
import com.projeto.integrador.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MinhaContaActivity extends DrawerCreator {


    private EditText textViewNomeUserLogado;
    private String nomeUsuarioLogado = AgroHelpApplication.getInstance().getUsuario().getNome();
    private EditText textViewCpfUserLogado;
    private String cpfUsuarioLogado = AgroHelpApplication.getInstance().getUsuario().getCpf();
    private EditText textViewEmailUserLogado;
    private String emailUsuarioLogado = AgroHelpApplication.getInstance().getUsuario().getEmail();
    private EditText textViewLoginUserLogado;
    private String loginUsuarioLogado = AgroHelpApplication.getInstance().getUsuario().getLogin();
    private EditText textViewSenhaUserLogado;
    private String senhaUsuarioLogado = AgroHelpApplication.getInstance().getUsuario().getSenha();
    private Integer id = AgroHelpApplication.getInstance().getUsuario().getId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null)
            savedInstanceState = new Bundle();
        savedInstanceState.putInt("layout", R.layout.activity_minha_conta);
        super.onCreate(savedInstanceState);


        textViewNomeUserLogado = (EditText) findViewById(R.id.nomeMinhaConta);
        textViewCpfUserLogado = (EditText) findViewById(R.id.cpfMinhaConta);
        textViewEmailUserLogado = (EditText) findViewById(R.id.emailMinhaConta);
        textViewLoginUserLogado = (EditText) findViewById(R.id.loginMinhaConta);
        textViewSenhaUserLogado = (EditText) findViewById(R.id.senhaMinhaConta);

        listarDadosMinhaConta();

    }

    public void listarDadosMinhaConta(){

        textViewNomeUserLogado.setText(nomeUsuarioLogado);
        textViewCpfUserLogado.setText(cpfUsuarioLogado);
        textViewEmailUserLogado.setText(emailUsuarioLogado);
        textViewLoginUserLogado.setText(loginUsuarioLogado);
        textViewSenhaUserLogado.setText(senhaUsuarioLogado);

    }

    public void voltarTelaPrincipal(View view){
        Intent intent = new Intent(this, FeedActivity.class);
        startActivity(intent);

    }

    public void submeterMudancas(View view) {
        textViewNomeUserLogado = (EditText) findViewById(R.id.nomeMinhaConta);
        textViewCpfUserLogado = (EditText) findViewById(R.id.cpfMinhaConta);
        textViewEmailUserLogado = (EditText) findViewById(R.id.emailMinhaConta);
        textViewLoginUserLogado = (EditText) findViewById(R.id.loginMinhaConta);
        textViewSenhaUserLogado = (EditText) findViewById(R.id.senhaMinhaConta);

        //if(textViewNomeUserLogado != null && textViewSenhaUserLogado != null && textViewEmailUserLogado != null && textViewSenhaUserLogado != null && textViewLoginUserLogado != null) {
            Usuario temp = new Usuario(textViewNomeUserLogado.getText().toString()
                    , textViewSenhaUserLogado.getText().toString()
                    , textViewCpfUserLogado.getText().toString()
                    , textViewEmailUserLogado.getText().toString()
                    , textViewLoginUserLogado.getText().toString());

        Call<Usuario> call = RetrofitService.getServico().updateUsuario(id, temp);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                   Toast.makeText(MinhaContaActivity.this, "Dados Alterados!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });
    }

    public void alteraSenha(View view) {

    }
    public void alteraLogin(View view) {

    }
    public void alteraEmail(View view) {

    }
    public void alteraNome(View view) {
        //textViewNomeUserLogado.setKeyListener(null);
    }
    public void alteraCpf(View view) {

    }
}


