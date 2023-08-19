package com.saurtech.teachersclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CommunityActivity extends AppCompatActivity {

    FloatingActionButton mCreatePost, mAskQuestion;
    ExtendedFloatingActionButton mCreate;
    TextView mCreatePostTV, mAskQuestionTV;
    Boolean areAllFABsVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        Toolbar toolbar = findViewById(R.id.communityToolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        ImageView backBtn = findViewById(R.id.community_back_arrow);
        backBtn.setOnClickListener(v -> {
            Intent backIntent = new Intent(CommunityActivity.this, MainActivity.class);
            startActivity(backIntent);
            finish();
        });

        mCreate = findViewById(R.id.mainFAB);

        mCreatePost = findViewById(R.id.create_post_FAB);
        mAskQuestion = findViewById(R.id.ask_question_FAB);

        mCreatePostTV = findViewById(R.id.create_post_TV);
        mAskQuestionTV = findViewById(R.id.create_question_TV);

        mCreatePost.setVisibility(View.GONE);
        mAskQuestion.setVisibility(View.GONE);
        mCreatePostTV.setVisibility(View.GONE);
        mAskQuestionTV.setVisibility(View.GONE);

        areAllFABsVisible = false;

        mCreate.shrink();

        mCreate.setOnClickListener(v -> {
            if (!areAllFABsVisible) {
                mCreatePost.show();
                mAskQuestion.show();
                mCreatePostTV.setVisibility(View.VISIBLE);
                mAskQuestionTV.setVisibility(View.VISIBLE);

                mCreate.extend();

                areAllFABsVisible = true;
            } else {
                mCreatePost.hide();
                mAskQuestion.hide();
                mCreatePostTV.setVisibility(View.GONE);
                mAskQuestionTV.setVisibility(View.GONE);

                mCreate.shrink();

                areAllFABsVisible = false;
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bot_nav_home);

    }
}