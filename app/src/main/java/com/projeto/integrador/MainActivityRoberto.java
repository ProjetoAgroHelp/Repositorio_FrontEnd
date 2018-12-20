/*package com.projeto.integrador;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.projeto.integrador.domain.CreditCard;
import com.projeto.integrador.domain.PaymentConnection;
import com.projeto.integrador.domain.Product;

import java.util.Observable;
import java.util.Observer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityRoberto extends AppCompatActivity {
    // tem um static dando erro aqui!

    /* Tire o comentário para ver os erros!

    private Product product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_roberto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initProduct();
        initViews( product );
    }


    //dados da tela principal descrição do orçamento
    private void initProduct(){
        product = new Product(
                "6658-3324599755412",
                "Plantação de Milho  ",
                "Plantação de milho para silagem, análise do solo, correção do solo, calagem, " +
                        "cuidados na colheita, armazenamento e estocagem em silos" +
                        "são 4 hectares de terra, com terra produtiva e plana com poucas dificuldades.",
                4,
                4000.00,
                pagamento);
    }

    private void initViews( Product product ){
        ((ImageView) findViewById(R.id.img)).setImageResource( product.getImg() );
        ((TextView) findViewById(R.id.name)).setText( product.getName() );
        ((TextView) findViewById(R.id.description)).setText( product.getDescription() );
        ((TextView) findViewById(R.id.stock)).setText( product.getStockString() );
        ((TextView) findViewById(R.id.price)).setText( product.getPriceString() );
    }

    //metodo pagamento, cancelar
    public void buy( View view ){
        new MDDialog.Builder(this)
                .setTitle("Pagamento")
                .setContentView(R.layout.content_main_roberto)
                .setNegativeButton("Cancelar", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .setPositiveButton("Finalizar", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View root = v.getRootView();
                        // dados do cartao
                        buttonBuying( true );
                        CreditCard creditCard = new CreditCard((Observer) MainActivityRoberto.this);
                        creditCard.setCardNumber( getViewContent( root, R.id.card_number ) );
                        creditCard.setName( getViewContent( root, R.id.name ) );
                        creditCard.setMonth( getViewContent( root, R.id.month ) );
                        creditCard.setYear( getViewContent( root, R.id.year ) );
                        creditCard.setCvv( getViewContent( root, R.id.cvv ) );
                        creditCard.setParcels( Integer.parseInt( getViewContent( root, R.id.parcels ) ) );

                        getPaymentToken( creditCard );
                    }
                })
                .create()
                .show();
    }

    private String getViewContent( View root, int id ){
        EditText field = (EditText) root.findViewById(id);
        return field.getText().toString();
    }
    // buscar pagamento token
    private void getPaymentToken( CreditCard creditCard ){
        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled( true );
        webView.addJavascriptInterface( creditCard, "Android" );
        webView.loadUrl("file:///android_asset/index.html");
    }

    private void showMessage( final String message ){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText( MainActivityRoberto.this, message, Toast.LENGTH_LONG ).show();
            }
        });
    }
    // atualizar numero do cartao se é valido ou não
    @Override
    public void update(Observable o, Object arg) {
        CreditCard creditCard = (CreditCard) o;

        if( creditCard.getToken() == null ){
            buttonBuying( false );
            showMessage( creditCard.getError() );
            return;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.25.221:8888/android-content_main_roberto/")
                .addConverterFactory( GsonConverterFactory.create() )
                .build();

        PaymentConnection paymentConnection = retrofit.create(PaymentConnection.class);
        Call<String> requester = paymentConnection.sendPayment(
                product.getId(),
                product.getPrice(),
                creditCard.getToken(),
                creditCard.getParcels()
        );

        requester.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                buttonBuying( false );
                showMessage( response.body() );
            }
            // mensagem de erro
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                buttonBuying( false );
                Log.e("log", "Error: "+t.getMessage());
            }
        });
    }
    // botao comprando
    private void buttonBuying( final boolean status ){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String label;

                label = getResources().getString(R.string.button_buy);
                if( status ){
                    label = getResources().getString(R.string.button_buying);
                }

                ((Button) findViewById(R.id.button_buy)).setText(label);
            }
        });
    }

}
*/