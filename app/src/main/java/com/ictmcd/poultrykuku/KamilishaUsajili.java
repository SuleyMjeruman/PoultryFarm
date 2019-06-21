package com.ictmcd.poultrykuku;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class KamilishaUsajili extends AppCompatActivity {

    private String CurrentUserID;
    private EditText Fname, Sname, Lname, Area, Age;
    private Spinner day, month, year;
    private Button Jisajili;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamilisha_usajili);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try {
            CurrentUserID = getIntent().getExtras().get("userID").toString();

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        try {
            myRef = FirebaseDatabase.getInstance().getReference("users").child(CurrentUserID);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


        Fname = findViewById(R.id.fname);
        Sname = findViewById(R.id.sname);
        Lname = findViewById(R.id.lname);
        Area = findViewById(R.id.area);
        Age = findViewById(R.id.age);
        day = findViewById(R.id.day);
        month = findViewById(R.id.month);
        year = findViewById(R.id.year);
        Jisajili = findViewById(R.id.btn_submit);

        String[] Days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31",};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Days);
        day.setAdapter(adapter);

        String[] Month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        ArrayAdapter<String> adapterMonth = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Month);
        month.setAdapter(adapterMonth);

        try {
            final ArrayList<String> years = new ArrayList<>();
            int thisYear = Calendar.getInstance().get(Calendar.YEAR);
            for (int i = 1900; i <= thisYear; i++) {
                years.add(Integer.toString(i));
            }
            ArrayAdapter<String> adapterYear = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, years);
            year.setAdapter(adapterYear);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


        Jisajili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisYear = Calendar.getInstance().get(Calendar.YEAR);

                int ActualBirthYear = Integer.valueOf(year.getSelectedItem().toString());

                int calAge = thisYear - ActualBirthYear;

                String ActualAge = String.valueOf(calAge);


                if (TextUtils.isEmpty(Fname.getText())) {
                    Fname.setError("Jaza Jina lako la kwanza");
                } else if (TextUtils.isEmpty(Sname.getText())) {
                    Sname.setError("Jaza jina lako la kati");
                } else if (TextUtils.isEmpty(Lname.getText())) {
                    Lname.setError("Jaza jina lako la mwisho");
                } else if (TextUtils.isEmpty(Area.getText())) {
                    Area.setError("Jaza mahali unapoishi");
                } else if (TextUtils.isEmpty(Age.getText())) {
                    Age.setError("Jaza umri wako sahihi");
                }else  if (!ActualAge.contentEquals(Age.getText())){
                    Toast.makeText(KamilishaUsajili.this, "Umri wako hauendani na tarehe yako ya kuzaliwa.", Toast.LENGTH_LONG).show();
                }
                else if (!TextUtils.isEmpty(Fname.getText()) && !TextUtils.isEmpty(Lname.getText()) && !TextUtils.isEmpty(Area.getText())
                        && !TextUtils.isEmpty(Age.getText()) && !TextUtils.isEmpty(Sname.getText()) && ActualAge.contentEquals(Age.getText())) {

                    String dateOfBirth = day.getSelectedItem().toString() + " " + month.getSelectedItem().toString() + " " + year.getSelectedItem().toString();

                    try {
                        myRef.child("fname").setValue(Fname.getText().toString());
                        myRef.child("sname").setValue(Sname.getText().toString());
                        myRef.child("lname").setValue(Lname.getText().toString());
                        myRef.child("area").setValue(Area.getText().toString());
                        myRef.child("age").setValue(Age.getText().toString());
                        myRef.child("dob").setValue(dateOfBirth);
                    } catch (Exception e) {
                        Toast.makeText(KamilishaUsajili.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }


                }


            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        try {

            final DatabaseReference Ref = FirebaseDatabase.getInstance().getReference("users");

            Ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.hasChildren()) {
                        Ref.child(CurrentUserID).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                if (dataSnapshot.exists()) {
                                    if (dataSnapshot.hasChild("fname") && dataSnapshot.hasChild("lname") &&
                                            dataSnapshot.hasChild("area") && dataSnapshot.hasChild("age") && dataSnapshot.hasChild("dob")) {

                                        Intent intent = new Intent(KamilishaUsajili.this, RecordDashboard.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }
}
