package com.projeto.integrador.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.projeto.integrador.R;
import com.projeto.integrador.domain.Proposta;
import android.content.Context;
import android.widget.TextView;

import java.util.List;

public class PropostaAdapter extends BaseAdapter {

    private Context contexto;
    private List<Proposta> lista;

    public PropostaAdapter(Context contexto, List<Proposta> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
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
        return linha;
    }
}
