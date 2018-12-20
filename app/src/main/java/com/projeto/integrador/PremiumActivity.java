package com.projeto.integrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PremiumActivity extends DrawerCreator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null)
            savedInstanceState = new Bundle();
        savedInstanceState.putInt("layout", R.layout.activity_main_premium);
        super.onCreate(savedInstanceState);
    }

    public void comprarVersaoPremium(View view) {
        Intent i = new Intent (PremiumActivity.this, ActivityPagamento.class);
        startActivity(i);
    }
}