package com.saurtech.teachersclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OnBoardingActivity extends AppCompatActivity {

    private final int[] onboardingScreens = {
            R.layout.on_boarding_1,
            R.layout.on_boarding_2,
            R.layout.on_boarding_3
    };

    private ViewGroup container;
    private int currentScreen = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        container = findViewById(R.id.board);
        showOnboardingScreen(currentScreen);
    }

    private void showOnboardingScreen(int screenIndex) {
        container.removeAllViews();
        View screenView = LayoutInflater.from(this).inflate(onboardingScreens[screenIndex], container, false);
        container.addView(screenView);
    }

    public void onNextButtonClick(View view) {
        currentScreen++;
        if (currentScreen < onboardingScreens.length) {
            showOnboardingScreen(currentScreen);
        } else {

            startActivity(new Intent(OnBoardingActivity.this, RegisterActivity.class));
            finish();
        }
    }
}