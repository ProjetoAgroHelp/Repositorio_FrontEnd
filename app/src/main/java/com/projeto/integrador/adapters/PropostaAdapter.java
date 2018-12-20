package com.projeto.integrador.adapters;

// MergeRoberto
import android.content.Context;
import android.util.Log;
//
// master
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
//MergeRoberto
import android.widget.TextView;

import com.projeto.integrador.R;
import com.projeto.integrador.domain.Proposta;
//

import com.projeto.integrador.R;
import com.projeto.integrador.domain.Proposta;
import android.content.Context;
import android.widget.TextView;
// master

import java.util.List;

public class PropostaAdapter extends BaseAdapter {

//MergeRoberto
    private Context context;
    private List<Proposta> lista;

    public PropostaAdapter(Context context, List<Proposta> lista) {
        this.context = context;
//
    private Context contexto;
    private List<Proposta> lista;

    public PropostaAdapter(Context contexto, List<Proposta> lista) {
        this.contexto = contexto;
//master
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
//MergeRoberto
        return position;
//
        return lista.get(position);
//master
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//MergeRoberto

        Proposta proposta = lista.get(position);
        Log.i("teste","------------> 2.2: "+ proposta.getDescricao());
        View linha = LayoutInflater.from(context).inflate(R.layout.linha_list_view_proposta_feed, null);

        TextView nomeUsuario = (TextView) linha.findViewById(R.id.nomeUsuario_postFeed);
        TextView descricaoServico = (TextView) linha.findViewById(R.id.descricaoServico_postFeed);
        TextView nomeFazenda = (TextView) linha.findViewById(R.id.nomeFazenda_postFeed);
        TextView prazoServico = (TextView) linha.findViewById(R.id.prazoServico_postFeed);

        //nomeUsuario.setText(proposta.getNomeDoUsuario());  --- precisamos ver isso aqui!
        descricaoServico.setText(proposta.getDescricao() + " descrição aqui");
        //nomeFazenda.setText(proposta.getFazenda());        --- precisamos ver isso aqui!
        prazoServico.setText(proposta.getPrazo() + "");

//
        //obter o objeto da lista na posição position
        //Aluno aluno = lista.get(position);
        Proposta proposta = lista.get(position);
        //obter a referncia da view
        View linha = LayoutInflater.from(contexto).inflate(R.layout.layout_item_listview_proposta, null);
        //preencher a linha

        TextView descricao = (TextView) linha.findViewById(R.id.textViewd);
        TextView prazo = (TextView) linha.findViewById(R.id.textViewp);


        descricao.setText(proposta.getDescricao());
        prazo.setText(proposta.getPrazo()+"");
        //Log.i("nome: ", aluno.getNome());
//master
        return linha;
    }
}
