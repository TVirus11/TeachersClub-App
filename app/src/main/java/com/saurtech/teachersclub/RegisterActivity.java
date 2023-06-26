package com.saurtech.teachersclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    TextView regText, alreadyReg;
    ImageView bgRegLine;
    Button regButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regText = findViewById(R.id.reg_text);
        alreadyReg = findViewById(R.id.already_reg);
        bgRegLine = findViewById(R.id.bg_line_reg);
        regButton = findViewById(R.id.signUp_btn);

        regButton.setOnClickListener(v -> {
            Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        });
    }
}