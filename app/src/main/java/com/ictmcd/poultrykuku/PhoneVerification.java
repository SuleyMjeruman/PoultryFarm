package com.ictmcd.poultrykuku;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneVerification extends AppCompatActivity {

    private String VerificationID;
    Spinner spinner;
    EditText NambariYaSimu, Msimbo;
    Button thidbitisha, ombaMsimbo;
    TextView textViewStatus, maelekezo, maelekezo2;
    private FirebaseAuth mAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_verification);

        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();

        spinner = findViewById(R.id.countryCode);
        String[] countriesCode = {"+255", "+254", "+256", "+250", "+257"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, countriesCode);
        spinner.setAdapter(adapter);
        NambariYaSimu = findViewById(R.id.namba);
        thidbitisha = findViewById(R.id.verify);
        ombaMsimbo = findViewById(R.id.requestCode);
        Msimbo = findViewById(R.id.codeInput);
        textViewStatus = findViewById(R.id.status);
        maelekezo = findViewById(R.id.maelekezo);
        maelekezo2 = findViewById(R.id.maelekezo2);

        thidbitisha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(Msimbo.getText()) || Msimbo.getText().toString().trim().length() < 6) {

                    Toast.makeText(PhoneVerification.this, "Weka talakimu sita za msimbo uliotumwa kwenya nambari yako ya simu.", Toast.LENGTH_SHORT).show();

                } else if (!TextUtils.isEmpty(Msimbo.getText())) {


                    progressDialog.setTitle("Inathibitisha Msimbo");
                    progressDialog.setMessage("Tafadhali Subiri....");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();

                    String code = Msimbo.getText().toString().trim();
                    verifyCode(code);
                }

            }
        });

        ombaMsimbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = spinner.getSelectedItem().toString() + NambariYaSimu.getText().toString().trim();

                if (TextUtils.isEmpty(NambariYaSimu.getText().toString().trim())) {
                    Toast.makeText(PhoneVerification.this, "Weka namba yako ya simu kwanza.", Toast.LENGTH_SHORT).show();
                } else if (NambariYaSimu.getText().toString().trim().length() < 9) {
                    Toast.makeText(PhoneVerification.this, "Weka namba iliyosahihi.", Toast.LENGTH_SHORT).show();
                } else if (!TextUtils.isEmpty(NambariYaSimu.getText())) {
                    progressDialog.setTitle("Inaomba Msimbo");
                    progressDialog.setMessage("Tafadhali Subiri....");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();

                    sendVerificationCode(phoneNumber);
                    thidbitisha.setEnabled(true);
                    thidbitisha.setBackgroundResource(R.drawable.register_back);
                    textViewStatus.setText("Msimbo wa uthibitisho umetumwa kwenye nambari " + NambariYaSimu.getText().toString().trim() + ",msimbo wa uthibitisho utajiweka moja kwa moja, na kama ikishindikana tafadhali weka msimbo kwa njia ya kawaida.");
                    maelekezo.setVisibility(View.GONE);
                    maelekezo2.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            Intent intent = new Intent(PhoneVerification.this, RecordDashboard.class);
            startActivity(intent);
            finish();
        }
    }

    private void verifyCode(String code) {
        PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(VerificationID, code);
        SignInWithCredential(phoneAuthCredential);
    }

    private void SignInWithCredential(PhoneAuthCredential phoneAuthCredential) {

        mAuth.signInWithCredential(phoneAuthCredential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            progressDialog.dismiss();
                            Intent intent = new Intent(PhoneVerification.this, RecordDashboard.class);
                            startActivity(intent);
                            finish();
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                AlertDialog.Builder AB = new AlertDialog.Builder(PhoneVerification.this);
                                AB.setCancelable(true);
                                AB.setMessage(task.getException().getMessage());
                                AlertDialog alertDialog = AB.create();
                                alertDialog.setTitle("Msimbo uliouweka haupo au sio shahihi.");
                                alertDialog.show();
                                progressDialog.dismiss();
                            }

                        }

                    }
                });
    }

    private void sendVerificationCode(String number) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                TaskExecutors.MAIN_THREAD,               // Activity (for callback binding)
                mCallbacks                 // OnVerificationStateChangedCallbacks
        );

    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks
            = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            VerificationID = s;
            progressDialog.dismiss();

        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            String code = phoneAuthCredential.getSmsCode();
            if (code != null) {
                progressDialog.setTitle("Inathibitisha Msimbo");
                progressDialog.setMessage("Tafadhali Subiri....");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                Msimbo.setText(code);
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

            AlertDialog.Builder AB = new AlertDialog.Builder(PhoneVerification.this);
            AB.setCancelable(true);
            AB.setMessage(e.getMessage());
            AlertDialog alertDialog = AB.create();
            alertDialog.setTitle("Error");
            alertDialog.show();
            progressDialog.dismiss();


        }
    };
}
