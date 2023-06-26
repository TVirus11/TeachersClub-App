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
    ImageView bgRegLine, exitMain;
    Button regButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regText = findViewById(R.id.reg_text);
        alreadyReg = findViewById(R.id.already_reg);
        bgRegLine = findViewById(R.id.bg_line_reg);
        regButton = findViewById(R.id.signUp_btn);
        exitMain = findViewById(R.id.exit_main);

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