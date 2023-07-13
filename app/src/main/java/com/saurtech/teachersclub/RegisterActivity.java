package com.saurtech.teachersclub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    TextView regText, alreadyReg;
    ImageView bgRegLine, exitMain;
    Button regButton;
    EditText fullNameET, emailET, createPassET, confirmPassET;
    AppCompatCheckBox consentCheck;

    FirebaseFirestore firebaseFirestore;
    DocumentReference documentReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regText = findViewById(R.id.reg_text);
        alreadyReg = findViewById(R.id.already_reg);

        bgRegLine = findViewById(R.id.bg_line_reg);
        exitMain = findViewById(R.id.exit_main);

        consentCheck = findViewById(R.id.consent_check);

        regButton = findViewById(R.id.signUp_btn);

        fullNameET = findViewById(R.id.full_name_et);
        emailET = findViewById(R.id.email_et);
        createPassET = findViewById(R.id.create_pass_et);
        confirmPassET = findViewById(R.id.confirm_pass_et);


        //Firebase FireStore Database
        FirebaseFirestore.setLoggingEnabled(true);

        firebaseFirestore = FirebaseFirestore.getInstance();
        documentReference = firebaseFirestore.collection("users").document();
        regButton.setOnClickListener(v -> {
            if (fullNameET.getText().toString().equals("")) {
                Toast.makeText(RegisterActivity.this, "Full Name is required", Toast.LENGTH_SHORT).show();
            } else if (emailET.getText().toString().equals("")) {
                Toast.makeText(RegisterActivity.this, "Email ID is required", Toast.LENGTH_SHORT).show();
            } else if (createPassET.getText().toString().equals("")) {
                Toast.makeText(RegisterActivity.this, "Please create a password", Toast.LENGTH_SHORT).show();
            } else if (!confirmPassET.getText().toString().equals(createPassET.getText().toString())) {
                Toast.makeText(RegisterActivity.this, "Password must be same", Toast.LENGTH_SHORT).show();
            } else {
                documentReference.get().addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        Toast.makeText(RegisterActivity.this, "The user with same details already exists", Toast.LENGTH_SHORT).show();
                    } else {
                        Map<String, Object> regEntry = new HashMap<>();
                        regEntry.put("Name", fullNameET.getText().toString());
                        regEntry.put("Email", emailET.getText().toString());
                        regEntry.put("Password", createPassET.getText().toString());

                        firebaseFirestore.collection("users")
                                .add(regEntry)
                                .addOnSuccessListener(documentReference -> Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show())
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.d("Error", e.getMessage());
                                    }
                                });
                        Intent mainIntent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(mainIntent);
                        finish();
                    }
                });
            }
        });
        //Firebase FireStore Database

        exitMain.setOnClickListener(v -> {
            Intent mainIntent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        });

        alreadyReg.setOnClickListener(v -> {
            Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        });
    }
}