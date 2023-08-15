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
        //mainText.setText("Welcome to Teachers Club!\n\nAt Teachers Club, we're committed to making education accessible and enjoyable for learners of all ages. Our mission is to connect students with experienced and dedicated tutors who are passionate about helping them achieve their learning goals.\n\nWhether you're a student seeking academic support, exam preparation, or skill enhancement, Teachers Club has you covered. Our platform brings together a diverse community of qualified tutors who excel in various subjects and fields. We understand that every learner is unique, so we provide a personalized and tailored learning experience to meet your individual needs.\n\n Why Choose Teachers Club?\n\n - Quality Educators: Our tutors are experts in their respective fields, ensuring that you receive high-quality instruction and guidance.\n\n - Flexible Learning: Learn at your own pace and schedule. Our platform offers flexibility for both students and tutors.\n\n - Comprehensive Subjects: From mathematics to languages, science to arts, we offer a wide range of subjects to cater to all learning interests.\n\n - Interactive Sessions: Engage in interactive sessions that encourage active learning and knowledge retention.\n\n - Seamless Booking: Easily find and book tutors based on your preferences, availability, and learning objectives.\n\n - Feedback and Growth: Our platform encourages open communication between students and tutors, fostering continuous improvement and growth.\n\n\n Join our community of learners and educators today and embark on a journey of knowledge, exploration, and achievement. Together, we're shaping a brighter future through education.\n For any inquiries or assistance, feel free to reach out to our dedicated support team. Thank you for choosing Teachers Club!");

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