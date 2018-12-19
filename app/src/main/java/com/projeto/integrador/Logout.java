package com.projeto.integrador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Logout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(Logout.this,MainActivity.class);
        startActivity(i);
    }

    public static class ExampleActivity extends AppCompatActivity {

        private static final ExampleActivity PSCheckout = ;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.example);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    //Fornece controle para LIB de Activity results
    PSCheckout.onActivityResult(this, requestCode, resultCode, data);//Controle Lib Activity Life Cycle
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    //Android 6+ fornece controle para LIB para request de permissões
    PSCheckout.onRequestPermissionsResult(this, requestCode, permissions, grantResults);//Controle Lib Activity Life Cycle
    }

    @Override
    public void onBackPressed() {
    if (PSCheckout.onBackPressed(this)) { //Controle Lib Button back
    super.onBackPressed();
    }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case android.R.id.home:
    PSCheckout.onHomeButtonPressed(this); //Controle Lib Home Button
    return true;
    default:
    return super.onOptionsItemSelected(item);
    }
    }

    @Override
    protected void onDestroy() {
    super.onDestroy();
    PSCheckout.onDestroy(); //Controle Lib Activity Life Cycle
    }
    }
}
