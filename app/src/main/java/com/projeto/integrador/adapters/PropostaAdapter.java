package com.projeto.integrador.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.projeto.integrador.R;
import com.projeto.integrador.domain.Proposta;

import java.util.List;

public class PropostaAdapter extends RecyclerView.Adapter<PropostaAdapter.PropostaViewHolder> {

    private Context context;
    private List<Proposta> lista;

    public PropostaAdapter(List<Proposta> lista) {
        this.lista = lista;
    }

    /* COMENTADO PARA TESTAR O RECYCLERVIEW
        @Override
        public int getCount() {
            return lista.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

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

            return linha;
        }
    */
    public static class PropostaViewHolder extends RecyclerView.ViewHolder{

        TextView nomeUsuario;
        TextView descricaoServico;
        TextView nomeFazenda;
        TextView prazoServico   ;

        public PropostaViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeUsuario = (TextView) itemView.findViewById(R.id.nomeUsuario_postFeed);
            descricaoServico = (TextView) itemView.findViewById(R.id.descricaoServico_postFeed);
            nomeFazenda = (TextView) itemView.findViewById(R.id.nomeFazenda_postFeed);
            prazoServico = (TextView) itemView.findViewById(R.id.prazoServico_postFeed);
        }
    }

    @NonNull
    @Override
    public PropostaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.linha_list_view_proposta_feed, parent, false);
        PropostaViewHolder pvh = new PropostaViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull PropostaViewHolder viewHolder, int i) {

        viewHolder.nomeUsuario.setText("Nome do Usuário aqui");
        viewHolder.descricaoServico.setText(lista.get(i).getDescricao() + " - Descrição da proposta aqui.");
        viewHolder.nomeFazenda.setText("Nome da Fazenda");
        viewHolder.prazoServico.setText(lista.get(i).getPrazo());

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}








































