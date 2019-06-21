package com.ictmcd.poultrykuku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RecordDashboard extends AppCompatActivity {
    private FirebaseAuth mAuth;
    CardView eggCollector, Madawa, Chanjo, Matumizi, Idadi, Mauzo, Mabanda, chakula, report;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mAuth = FirebaseAuth.getInstance();
        eggCollector = findViewById(R.id.eggCollector);
        Madawa = findViewById(R.id.madawa);
        Chanjo = findViewById(R.id.chanjo);
        Matumizi = findViewById(R.id.matumizi);
        Idadi = findViewById(R.id.idadi);
        Mauzo = findViewById(R.id.mauzo);
        Mabanda = findViewById(R.id.mabanda);
        chakula = findViewById(R.id.chakula);
        report = findViewById(R.id.report);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);

        eggCollector.startAnimation(animation);
        Madawa.startAnimation(animation);
        Chanjo.startAnimation(animation);
        Matumizi.startAnimation(animation);
        Idadi.startAnimation(animation);
        Mauzo.startAnimation(animation);
        Mabanda.startAnimation(animation);
        chakula.startAnimation(animation);
        report.startAnimation(animation);

        MabandaClicked();
        eggCollectorClicked();
        MadawaClicked();
        ChanjoClicked();
        MatumiziClicked();
        IdadiClicked();
        MauzoClicked();
        chakulaClicked();
        reportClicked();

    }

    private void MabandaClicked() {
        Mabanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecordDashboard.this, Mabanda.class);
                startActivity(intent);
            }
        });
    }

    private void eggCollectorClicked() {
    }

    private void MadawaClicked() {
    }

    private void ChanjoClicked() {
    }

    private void MatumiziClicked() {
    }

    private void IdadiClicked() {
    }

    private void MauzoClicked() {
    }

    private void chakulaClicked() {
    }

    private void reportClicked() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.toka, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.toka) {
            SignOut();
        }

        return true;
    }

    private void SignOut() {

        mAuth.signOut();
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
        finish();
    }


}
