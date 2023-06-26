package com.saurtech.teachersclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    TextView regText, alreadyReg;
    ImageView bgRegLine, exitMain;
    Button regButton;
    EditText fullNameET, emailET, createPassET, confirmPassET;
    AppCompatCheckBox consentCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullNameET = findViewById(R.id.full_name_et);
//        String inputName = fullNameET.getText().toString().trim();
//        if (inputName.isEmpty()) {
//            fullNameET.setError("Full name is required");
//        }

        emailET = findViewById(R.id.email_et);
//        String inputEmail = emailET.getText().toString().trim();
//        if (inputEmail.isEmpty()) {
//            emailET.setError("Email is required");
//        }

        createPassET = findViewById(R.id.create_pass_et);
//        String inputCreatePass = createPassET.getText().toString().trim();
//        if (inputCreatePass.isEmpty()) {
//            createPassET.setError("Password is required");
//        }

        confirmPassET = findViewById(R.id.confirm_pass_et);
//        String inputConfirmPass = confirmPassET.getText().toString().trim();
//        if (inputConfirmPass.isEmpty()) {
//            confirmPassET.setError("Confirm password is required");
//        }

        regText = findViewById(R.id.reg_text);
        alreadyReg = findViewById(R.id.already_reg);

        bgRegLine = findViewById(R.id.bg_line_reg);
        exitMain = findViewById(R.id.exit_main);

        regButton = findViewById(R.id.signUp_btn);

        consentCheck = findViewById(R.id.consent_check);

        exitMain.setOnClickListener(v -> {
            Intent mainIntent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        });

        regButton.setOnClickListener(v -> {
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