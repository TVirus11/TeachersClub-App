package com.saurtech.teachersclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    ImageView bgLine, exitReg;
    TextView loginText, emailTV, passTV, consentTV, newUserTV;
    EditText emailET, passET;
    Button loginBtn;
    AppCompatCheckBox consentCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bgLine = findViewById(R.id.bg_line_login);
        exitReg = findViewById(R.id.exit_reg);

        loginText = findViewById(R.id.login_text);
        emailTV = findViewById(R.id.email_tv_login);
        passTV = findViewById(R.id.pass_tv_login);
        consentTV = findViewById(R.id.consent_text);
        newUserTV = findViewById(R.id.new_user);

        emailET = findViewById(R.id.email_et_login);
        passET = findViewById(R.id.pass_et_login);

        consentCheck = findViewById(R.id.consent_check);

        loginBtn = findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(v -> {
            Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        });

        newUserTV.setOnClickListener(v -> {
            Intent regIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(regIntent);
            finish();
        });
    }
}