package com.example.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class nav_drawer extends AppCompatActivity
{
    Toolbar toolbar;
    AppBarLayout appBarLayout;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);

        toolbar = findViewById(R.id.toolbar);
        appBarLayout = findViewById(R.id.app_bar);
        drawerLayout = findViewById(R.id.nav_drawer);
        navigationView = findViewById(R.id.nav_view);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);
        floatingActionButton = findViewById(R.id.fab);

        setSupportActionBar(toolbar);
        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Whatsapp");
        }

//Navigation drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                int id = item.getItemId();
                if(id==R.id.profile)
                {
                    loadFragment(new profile_Fragment());
                }
                else if (id==R.id.add_acc)
                {
                    Intent intent = new Intent(getApplicationContext(),add_account.class);
                    startActivity(intent);
                }
                else if (id==R.id.switch_acc)
                {
                    Intent intent = new Intent(getApplicationContext(),switch_account.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(),saved_data.class);
                    startActivity(intent);
                }
                return false;
            }

        });
//Floating action button
        floatingActionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
//                Snackbar given
//                Snackbar.make(v,"Chat",Snackbar.LENGTH_LONG).setAction("Action",null).show();
                Intent intent = new Intent(getApplicationContext(),Contacts.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        super.onBackPressed();
    }

    private void loadFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.nav_content, fragment);
        fragmentTransaction.commit();
    }

}