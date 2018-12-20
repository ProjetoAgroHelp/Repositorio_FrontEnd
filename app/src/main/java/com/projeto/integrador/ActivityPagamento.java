package com.projeto.integrador;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

public class ActivityPagamento extends DrawerCreator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null)
            savedInstanceState = new Bundle();
        savedInstanceState.putInt("layout", R.layout.content_main_roberto);
        super.onCreate(savedInstanceState);
    }

    public void buy(View view) {
        Dialog dialog = new Dialog(this, R.style.Widget_AppCompat_PopupWindow);
        dialog.setContentView(R.layout.payment_roberto);
        dialog.show();
    }
}