package com.saurtech.teachersclub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    LinearLayout profileBg;

    ImageView profileBackArrow, profilePic;
    TextView profileName, profileEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileBg = findViewById(R.id.profile_bg);

        profileBackArrow = findViewById(R.id.profile_back_arrow);
        profilePic = findViewById(R.id.profile_pic);

        profileName = findViewById(R.id.profile_name);
        profileEmail = findViewById(R.id.profile_email);
    }
}