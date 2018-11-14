package projeto.integrador.main.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.projeto.integrador.R;

import java.util.List;

import projeto.integrador.main.model.Usuario;

public class UsuarioAdapter extends BaseAdapter {

    private Context contexto;
    private List<Usuario> lista;

    public UsuarioAdapter(Context contexto, List<Usuario> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //obter o objeto da lista na posição position
        Usuario usuarios = lista.get(position);
        //obter a referncia da view
        View linha = LayoutInflater.from(contexto).inflate(R.layout.activity_login_teste, null);
        //preencher a linha
        TextView login = (TextView) linha.findViewById(R.id.login);
        TextView senha = (TextView) linha.findViewById(R.id.senha);
        TextView email = (TextView) linha.findViewById(R.id.email);

        login.setText(usuarios.getLogin());
        senha.setText(usuarios.getSenha());
        email.setText(usuarios.getEmail());

        return linha;
    }
}
