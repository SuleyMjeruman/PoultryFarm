package com.ictmcd.poultrykuku;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Mabanda extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton OpenCustomDialog;
    final Context context = this;
    String CurrentDate,ChosedDate;
    int yearX, monthX, day;
    final int DIALOG_ID = 0;
    View dialogView;
    private DatabaseReference myRef;
    private String CurrentUser;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mabanda);
        toolbar = findViewById(R.id.main_toolbar);

        mAuth = FirebaseAuth.getInstance();
        myRef = FirebaseDatabase.getInstance().getReference();


        setSupportActionBar(toolbar);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Mabanda");
        } catch (NullPointerException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        Calendar calendar = Calendar.getInstance();
        yearX = calendar.get(Calendar.YEAR);
        monthX = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        CurrentDate = simpleDateFormat.format(calendar.getTime());

        OpenCustomDialog = findViewById(R.id.wekaBanda);

        OpenCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showCustomDialog();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() != null)
        {
            CurrentUser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        }
    }

    private void showCustomDialog() {

        //before inflating the custom alert dialog layout, we will get the current activity viewgroup
        ViewGroup viewGroup = findViewById(android.R.id.content);

        //then we will inflate the custom alert dialog xml that we created
         dialogView = LayoutInflater.from(this).inflate(R.layout.costum_dialog_mabanda, viewGroup, false);


        //Now we need an AlertDialog.Builder object
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);

        //setting the view of the builder to our custom view that we already inflated
        builder.setView(dialogView);

        //finally creating the alert dialog and displaying it
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        TextView tarehe = dialogView.findViewById(R.id.TareheYaUsajili);
        tarehe.setText(CurrentDate);



        dialogView.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        dialogView.findViewById(R.id.hifadhi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        dialogView.findViewById(R.id.datePicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog(DIALOG_ID);



            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        super.onCreateDialog(id);
        if (id == DIALOG_ID) {
            return new DatePickerDialog(this, datePickerListener, yearX, monthX, day);
        } else
            return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            yearX = year;
            monthX = month + 1;
            String mwezi = "";
            switch (monthX){
                case 1:
                    mwezi = "Jan";
                    break;
                case 2:
                    mwezi = "Feb";
                    break;
                case 3:
                    mwezi = "Mar";
                    break;
                case 4:
                    mwezi = "Apr";
                    break;
                case 5:
                    mwezi = "May";
                    break;
                case 6:
                    mwezi = "Jun";
                    break;
                case 7:
                    mwezi = "Jul";
                    break;
                case 8:
                    mwezi = "Aug";
                    break;
                case 9:
                    mwezi = "Sep";
                    break;
                case 10:
                    mwezi = "Oct";
                    break;
                case 11:
                    mwezi = "Nov";
                    break;
                case 12:
                    mwezi = "Dec";
                    break;

            }
            day = dayOfMonth;
            ChosedDate = day +" "+mwezi+" "+yearX;
            TextView tarehe = dialogView.findViewById(R.id.TareheYaUsajili);
            tarehe.setText(ChosedDate);

        }
    };


}
