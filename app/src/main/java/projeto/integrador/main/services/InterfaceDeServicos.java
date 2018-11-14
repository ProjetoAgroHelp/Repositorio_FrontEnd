package projeto.integrador.main.services;

import java.util.List;
import retrofit2.Call;
import projeto.integrador.main.model.Usuario;
import retrofit2.http.GET;

public interface InterfaceDeServicos {

    @GET("/usuarios")
    Call<List<Usuario>> obterDatos();
}
