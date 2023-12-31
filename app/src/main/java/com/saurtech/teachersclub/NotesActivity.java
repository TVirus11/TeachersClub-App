package com.saurtech.teachersclub;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class NotesActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView backArrow;
    CardView card5, card6, card7, card8, card9, card10, card11, card12,
            cardComputer, cardJEE, cardProgramming, cardGenScience, cardGenStudies, cardEnglish;
    TextView toolbarTitle, classTitle, compTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        toolbar = findViewById(R.id.notesToolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        toolbarTitle = findViewById(R.id.notesToolbarTitle);
        classTitle = findViewById(R.id.classNotesTitle);
        compTitle = findViewById(R.id.competitiveNotesTitle);

        backArrow = findViewById(R.id.notesBackArrow);
        backArrow.setOnClickListener(v -> {
            Intent mainIntent = new Intent(NotesActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        });

        card5 = findViewById(R.id.cardView1);
        card5.setOnClickListener(v -> {

        });

        card6 = findViewById(R.id.cardView2);
        card6.setOnClickListener(v -> {

        });

        card7 = findViewById(R.id.cardView3);
        card7.setOnClickListener(v -> {

        });

        card8 = findViewById(R.id.cardView4);
        card8.setOnClickListener(v -> {

        });

        card9 = findViewById(R.id.cardView5);
        card9.setOnClickListener(v -> {

        });

        card10 = findViewById(R.id.cardView6);
        card10.setOnClickListener(v -> {

        });

        card11 = findViewById(R.id.cardView7);
        card11.setOnClickListener(v -> {

        });

        card12 = findViewById(R.id.cardView8);
        card12.setOnClickListener(v -> {

        });

        cardComputer = findViewById(R.id.cardView9);
        cardComputer.setOnClickListener(v -> {

        });

        cardJEE = findViewById(R.id.cardView10);
        cardJEE.setOnClickListener(v -> {

        });

        cardProgramming = findViewById(R.id.cardView11);
        cardProgramming.setOnClickListener(v -> {

        });

        cardGenScience = findViewById(R.id.cardView12);
        cardGenScience.setOnClickListener(v -> {

        });

        cardGenStudies = findViewById(R.id.cardView13);
        cardGenStudies.setOnClickListener(v -> {

        });

        cardEnglish = findViewById(R.id.cardView14);
        cardEnglish.setOnClickListener(v -> {

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