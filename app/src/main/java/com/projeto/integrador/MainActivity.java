package com.projeto.integrador;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayoutMain;
    private ActionBarDrawerToggle actionBarDrawerToggleMain;
    private NavigationView navigationViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayoutMain = (DrawerLayout) findViewById(R.id.activity_main);
        actionBarDrawerToggleMain = new ActionBarDrawerToggle(this, drawerLayoutMain, R.string.abrir, R.string.fechar);

        drawerLayoutMain.addDrawerListener(actionBarDrawerToggleMain);
        actionBarDrawerToggleMain.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationViewMain = (NavigationView) findViewById(R.id.navigationMain);
        navigationViewMain.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggleMain.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
