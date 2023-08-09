package com.saurtech.teachersclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class GetSupportActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView contactUsTV, emailIDTV, mobileNoTV, messageTV, otherWaysTV, mailAtTV, callAtTV, chatTV;
    EditText emailET, mobileNoET, messageET;
    Button sendBtn, chatBtn;
    View divider, divider1;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_support);

        toolbar = findViewById(R.id.contactUsToolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        contactUsTV = findViewById(R.id.contactUsTV);
        emailIDTV = findViewById(R.id.emailContactTV);
        mobileNoTV = findViewById(R.id.mobileContactTV);
        messageTV = findViewById(R.id.messageContactTV);
        otherWaysTV = findViewById(R.id.otherWaysTV);
        mailAtTV = findViewById(R.id.contactEmailID);
        callAtTV = findViewById(R.id.contactCallTollFree);
        chatTV = findViewById(R.id.contactChatBot);

        emailET = findViewById(R.id.emailContactET);
        mobileNoET = findViewById(R.id.mobileContactET);
        messageET = findViewById(R.id.messageContactET);

        sendBtn = findViewById(R.id.contactUsSendBtn);
        chatBtn = findViewById(R.id.chatBotBtn);

        divider = findViewById(R.id.divider);
        divider1 = findViewById(R.id.divider1);

        backButton = findViewById(R.id.support_back_arrow);
        backButton.setOnClickListener(v -> {
            Intent mainIntent = new Intent(GetSupportActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        });
    }
}