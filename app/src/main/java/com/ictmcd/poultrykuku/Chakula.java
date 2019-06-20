package com.ictmcd.poultrykuku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Chakula extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chakula);
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Lishe");
        } catch (NullPointerException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void openAinaYaVyakulaVyaKukuVideo (View view){
        Intent intent = new Intent(Chakula.this,Vyakula_vya_kuku_video.class);
        startActivity(intent);
    }

    public void openFaidaYaChakulaVyaKukuVideo (View view){
        Intent intent = new Intent(Chakula.this,Faida_za_vyakula_vya_kuku.class);
        startActivity(intent);
    }

    public void openKupimaVideo (View view){
        Intent intent = new Intent(Chakula.this,kupima_na_kuchanganya_chakula.class);
        startActivity(intent);
    }
}
