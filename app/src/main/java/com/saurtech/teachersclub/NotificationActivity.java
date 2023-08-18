package com.saurtech.teachersclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Toolbar toolbar = findViewById(R.id.notificationToolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        ImageView notiBackArrow = findViewById(R.id.noti_back_arrow);
        notiBackArrow.setOnClickListener(v -> {
            Intent backMainIntent = new Intent(NotificationActivity.this, MainActivity.class);
            startActivity(backMainIntent);
            finish();
        });


        //Add
        MobileAds.initialize(this, initializationStatus -> {
        });

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111"); //Test Ad Unit ID

        adView = findViewById(R.id.adViewNotes);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        //Add
    }
}