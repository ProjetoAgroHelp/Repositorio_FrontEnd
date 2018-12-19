package com.projeto.integrador;

import android.os.Bundle;

public class PremiumActivity extends DrawerCreator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null)
            savedInstanceState = new Bundle();
        savedInstanceState.putInt("layout", R.layout.activity_main_premium);

    }
}
