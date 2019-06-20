package com.ictmcd.poultrykuku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MiundombinuObjective extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miundombinu_objective);

        Toolbar toolbar =findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void openMiundombinu(View view){
        Intent intent = new Intent(MiundombinuObjective.this,MainActivity.class);
        startActivity(intent);
    }
}
