package com.projeto.integrador;

import android.content.Intent;
import android.os.Bundle;

import com.projeto.integrador.domain.Usuario;

public class FeedActivity extends DrawerCreator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null)
            savedInstanceState = new Bundle();
        savedInstanceState.putInt("layout", R.layout.telamiolo);
        super.onCreate(savedInstanceState);
    }
}
