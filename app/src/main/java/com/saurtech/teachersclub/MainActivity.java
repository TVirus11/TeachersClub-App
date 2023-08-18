package com.saurtech.teachersclub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    Button okayBtn, submitBtn;
    RatingBar ratingsBar;
    ImageView settingsMain, notiMain;
    EditText search;
    TextView aTViewAll, cViewAll, nViewAll;

    WebView activeWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settingsMain = findViewById(R.id.settingsMain);
        settingsMain.setOnClickListener(v -> {
            Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(settingsIntent);
            finish();
        });

        notiMain = findViewById(R.id.notificationMain);
        notiMain.setOnClickListener(v -> {
            Intent notiIntent = new Intent(MainActivity.this, NotificationActivity.class);
            startActivity(notiIntent);
            finish();
        });

        search = findViewById(R.id.searchMain);

        aTViewAll = findViewById(R.id.availableTeachersViewAll);


        cViewAll = findViewById(R.id.courseViewAllTV);
        cViewAll.setOnClickListener(v -> {
            Intent mainCoursesIntent = new Intent(MainActivity.this, CoursesActivity.class);
            startActivity(mainCoursesIntent);
            finish();
        });

        nViewAll = findViewById(R.id.notesViewAllTV);
        nViewAll.setOnClickListener(v -> {
            Intent mainNotesIntent = new Intent(MainActivity.this, NotesActivity.class);
            startActivity(mainNotesIntent);
            finish();
        });

        //App Check
        FirebaseApp.initializeApp(this);
        FirebaseAppCheck firebaseAppCheck = FirebaseAppCheck.getInstance();
        firebaseAppCheck.installAppCheckProviderFactory(
                PlayIntegrityAppCheckProviderFactory.getInstance());
        //App Check

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        setNavigationViewListener();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent homeIntent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(homeIntent);

        } else if (id == R.id.nav_profile) {
            Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(profileIntent);

        } else if (id == R.id.nav_find_teacher) {
            findTeacherDialog();

        } else if (id == R.id.nav_courses) {
            Intent courseIntent = new Intent(MainActivity.this, CoursesActivity.class);
            startActivity(courseIntent);

        } else if (id == R.id.nav_notes) {
            Intent notesIntent = new Intent(MainActivity.this, NotesActivity.class);
            startActivity(notesIntent);

        } else if (id == R.id.nav_logout) {
            //TODO

        } else if (id == R.id.nav_about) {
            Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(aboutIntent);

        } else if (id == R.id.nav_FAQ) {
            setContentView(R.layout.faq_webview);
            WebView wV = findViewById(R.id.faq);
            wV.loadUrl("file:///android_asset/FAQs.html");
            activeWebView = wV;

        } else if (id == R.id.nav_support) {
            Intent supportActivity = new Intent(MainActivity.this, GetSupportActivity.class);
            startActivity(supportActivity);

        } else if (id == R.id.nav_privacy) {
            WebView pp = new WebView(this);
            pp.loadUrl("teachersclub.netlify.app/privacy");
            setContentView(pp);
            if (pp.canGoBack()) {
                pp.goBack();
            } else {
                super.onBackPressed();
            }

        } else if (id == R.id.nav_tnc) {
            WebView TnC = new WebView(this);
            TnC.loadUrl("teachersclub.netlify.app/terms");
            setContentView(TnC);
            if (TnC.canGoBack()) {
                TnC.goBack();
            } else {
                super.onBackPressed();
            }
        } else if (id == R.id.nav_rate) {
            ratingsDialog();
        } else if (id == R.id.nav_community) {
            Intent communityIntent = new Intent(MainActivity.this, CommunityActivity.class);
            startActivity(communityIntent);
        }

        //close navigation drawer
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (activeWebView != null && activeWebView.canGoBack()) {
            activeWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private void setNavigationViewListener() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void findTeacherDialog() {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.find_teacher_dialog);
        Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        okayBtn = dialog.findViewById(R.id.okayBtn);
        okayBtn.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    public void ratingsDialog() {
        Dialog dialog = new Dialog(MainActivity.this);

        ratingsBar = (RatingBar) dialog.findViewById(R.id.ratingBar);
        dialog.setContentView(R.layout.rate_me);

        Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        submitBtn = dialog.findViewById(R.id.submitButton);
        submitBtn.setOnClickListener(v -> {
            Toast.makeText(this, "Ratings Submitted", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        dialog.show();
    }
}