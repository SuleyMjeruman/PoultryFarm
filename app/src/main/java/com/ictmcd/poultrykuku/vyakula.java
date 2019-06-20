package com.ictmcd.poultrykuku;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class vyakula extends AppCompatActivity {
    public int kilo;
    public Button mahindi,pumba,mashudu,mifupa,damu,dagaa,chokaa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vyakula);
        Intent intent = getIntent();

        kilo= intent.getIntExtra("kilo",0);

        mahindi=findViewById(R.id.mahindi);
        pumba=findViewById(R.id.pumba);
        mashudu=findViewById(R.id.mashudu);
        mifupa=findViewById(R.id.mifupa);
        damu=findViewById(R.id.damu);
        dagaa=findViewById(R.id.dagaa);
        chokaa=findViewById(R.id.chokaa);


        calculateRatio();


    }
    public void calculateRatio(){
        double mahindiKilo= kilo * 3.0 / 10.0;
        String mahindiText = getString(R.string.kilogramDouble, mahindiKilo);
        mahindi.setText(String.valueOf(mahindiText));

        double pumbaKilo= kilo * 2.0 / 10.0;
        String pumbaText = getString(R.string.kilogramDouble, pumbaKilo);
        pumba.setText(String.valueOf(pumbaText));

        double mashuduKilo= kilo * 2.0 / 10.0;
        String mashuduText = getString(R.string.kilogramDouble, mashuduKilo);
        mashudu.setText(String.valueOf(mashuduText));

        double mifupaKilo= kilo * 1.0 / 10.0;
        String mifupaText = getString(R.string.kilogramDouble, mifupaKilo);
        mifupa.setText(String.valueOf(mifupaText));

        double damuKilo= kilo * 0.5 / 10.0;
        String damuText = getString(R.string.kilogramDouble, damuKilo);
        damu.setText(String.valueOf(damuText));

        double dagaaKilo= kilo * 1.0 / 10.0;
        String dagaaText = getString(R.string.kilogramDouble, dagaaKilo);
        dagaa.setText(String.valueOf(dagaaText));

        double chokaaKilo= kilo * 0.5 / 10.0;
        String chokaaText = getString(R.string.kilogramDouble, chokaaKilo);
        chokaa.setText(String.valueOf(chokaaText));



    }
}
