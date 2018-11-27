package com.projeto.integrador;

import android.app.Activity;
import android.os.Bundle;

public class FeedActivity extends DrawerCreator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null)
            savedInstanceState = new Bundle();
        savedInstanceState.putInt("layout", R.layout.telamiolo);
        super.onCreate(savedInstanceState);
    }
}
