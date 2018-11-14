package projeto.integrador.main.activities;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.projeto.integrador.R;

import java.util.List;

import projeto.integrador.main.model.Usuario;
import projeto.integrador.main.services.InterfaceDeServicos;
import projeto.integrador.main.services.RetrofitService;
import projeto.integrador.main.utils.UsuarioAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_teste);

        dadosUsuario();
    }

    private void dadosUsuario() {

        InterfaceDeServicos services = RetrofitService.getServico();
        Call<List<Usuario>> call = services.obterDatos();


        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                List<Usuario> usuarios = response.body();
                //O método setListAdapter foi herdado de ListActivity
                setListAdapter(new UsuarioAdapter(LoginActivity.this, usuarios));
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Log.i("debug", t.getMessage());
            }
        });
    }
}
