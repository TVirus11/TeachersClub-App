package com.saurtech.teachersclub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    ImageView splashImg;
    TextView splashText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashImg = findViewById(R.id.splashImg);
        splashText = findViewById(R.id.splashText);

        new Handler().postDelayed(() -> {
            Intent onBoardIntent = new Intent(SplashActivity.this, OnBoardingActivity.class);
            startActivity(onBoardIntent);
            finish();
        }, 3000);
    }
}