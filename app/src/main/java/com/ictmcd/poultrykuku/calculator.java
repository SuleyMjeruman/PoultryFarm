package com.ictmcd.poultrykuku;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class calculator extends AppCompatActivity {
    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Toolbar toolbar =findViewById(R.id.toolbarCalculatorObjective);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button=findViewById(R.id.inayofuata);
        editText=findViewById(R.id.kilo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=editText.getText().toString();
                if(string.isEmpty()){
                    final AlertDialog.Builder builder = new AlertDialog.Builder(calculator.this);
                    builder.setMessage("Weka kiasi cha chakula ili kuendelea !");
                    builder.setCancelable(true);
                    builder.setNegativeButton("SAWA", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else{
                    int kilo = Integer.parseInt(string);
                    Intent intent=new Intent(getApplicationContext(),vyakula.class);
                    intent.putExtra("kilo",kilo);
                    startActivity(intent);

                }
            }
        });

    }
}
