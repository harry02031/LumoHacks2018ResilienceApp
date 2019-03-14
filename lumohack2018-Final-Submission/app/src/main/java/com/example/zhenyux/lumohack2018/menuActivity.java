package com.example.zhenyux.lumohack2018;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.zhenyux.lumohack2018.fragments.BotFragment;
import com.example.zhenyux.lumohack2018.fragments.ProfileFragment;
import com.example.zhenyux.lumohack2018.fragments.ReferenceFragment;
import com.example.zhenyux.lumohack2018.fragments.ResourceFragment;

public class menuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ProfileFragment()).commit();
            navigationView.setCheckedItem(R.id.profile);
        }
    }
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                break;
            case R.id.bot:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BotFragment()).commit();
                break;
            case R.id.resource:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ResourceFragment()).commit();
                break;
            case R.id.reference:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ReferenceFragment()).commit();
                break;
            case R.id.logout:
                Toast.makeText(this,"logout",Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static Intent makeIntent(Context context){
        Intent intent = new Intent(context,menuActivity.class);
        return intent;
    }
}
