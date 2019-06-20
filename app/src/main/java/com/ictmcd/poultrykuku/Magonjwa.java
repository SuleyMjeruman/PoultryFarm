package com.ictmcd.poultrykuku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Magonjwa extends AppCompatActivity {
    Toolbar toolbar;
    CardView virus,bacteria,protozoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magonjwa);
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        virus = findViewById(R.id.virus);
        bacteria = findViewById(R.id.bacteria);
        protozoa = findViewById(R.id.protozoa);
        CardsClicks();
        setSupportActionBar(toolbar);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Magonjwa");
        } catch (NullPointerException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void CardsClicks(){

        virus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Magonjwa.this,virusi.class);
                startActivity(intent);
            }
        });

        bacteria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Magonjwa.this,bacteria.class);
                startActivity(intent);
            }
        });

        protozoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Magonjwa.this,protozoa.class);
                startActivity(intent);
            }
        });

    }

}
