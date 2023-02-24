package com.example.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class collapsing_toolbar extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        FloatingActionButton floatingActionButton;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar);

        floatingActionButton = findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
//                Snackbar.make(v,"Chat",Snackbar.LENGTH_LONG).setAction("Action",null).show();
                Intent intent = new Intent(getApplicationContext(),Contacts.class);
                startActivity(intent);
            }
        });
    }
}