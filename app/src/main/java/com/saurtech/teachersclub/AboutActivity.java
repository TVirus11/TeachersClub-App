package com.saurtech.teachersclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class AboutActivity extends AppCompatActivity {

    TextView mainText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = findViewById(R.id.aboutUsToolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        mainText = findViewById(R.id.aboutUsText);

        //Add
        MobileAds.initialize(this, initializationStatus -> {
        });

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111"); //Test Ad Unit ID

        adView = findViewById(R.id.adViewAboutUs);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        //Add

    }
}