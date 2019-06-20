package com.ictmcd.poultrykuku;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class dashboard extends AppCompatActivity {
    CardView ainaKuku,miundombinu;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        try {
            getSupportActionBar().setTitle("Ufugaji Bora Wa Kuku");
        } catch (NullPointerException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        ainaKuku=findViewById(R.id.ainaKuku);
        ainaKuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dashboard.this,ainakuku_objective.class));
            }
        });

        miundombinu = findViewById(R.id.miundombinu);

        miundombinu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this,MiundombinuObjective.class);
                startActivity(intent);
            }
        });
    }

    public void MagonjwaClicked(View view){
        Intent intent = new Intent(dashboard.this,MagonjwaObjective.class);
        startActivity(intent);
    }

    public  void Lishe(View view){
        Intent intent = new Intent(dashboard.this,ObjectiveLishe.class);
        startActivity(intent);
    }

    public void openCalculator(View view){
        startActivity(new Intent(dashboard.this,calculator.class));
    }
}
