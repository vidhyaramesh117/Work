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

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.nav_drawer);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView=findViewById(R.id.bottom_nav);
        setSupportActionBar(toolbar);

//        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
//        bottomNavigationView.setOnItemSelectedListener(this);


//        drawer

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                int id = item.getItemId();
                if (id==R.id.profile)
                {
                    loadFragment(new Profile_Fragment());
                }
                else if (id==R.id.cloud)
                {
                    Toast.makeText(MainActivity.this, "Cloud storage", Toast.LENGTH_SHORT).show();
                }
                else if (id==R.id.logout)
                {
                    Toast.makeText(MainActivity.this, "Log out", Toast.LENGTH_SHORT).show();
                }
                else{
                    loadFragment(new Profile_Fragment());
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }



        Fragment fragment = new Personal_Fragment();



        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.personal:
                        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_content,personal_fragment).commit();
                        return true;
                    case R.id.group:
                        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_content,group_fragment).commit();
                        return true;
                }
                return false;
            }
        });




    @Override
    public void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }

    private void loadFragment(Fragment fragment)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.contents,fragment);
        ft.commit();
    }




}