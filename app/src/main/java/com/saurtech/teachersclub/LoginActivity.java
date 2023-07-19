package com.saurtech.teachersclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class LoginActivity extends AppCompatActivity {

    ImageView bgLine, exitReg;
    TextView loginText, emailTV, passTV, consentTV, newUserTV;
    EditText emailET, passET;
    Button loginBtn;
    AppCompatCheckBox consentCheck;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bgLine = findViewById(R.id.bg_line_login);
        exitReg = findViewById(R.id.exit_reg);

        loginText = findViewById(R.id.login_text);
        emailTV = findViewById(R.id.email_tv_login);
        passTV = findViewById(R.id.pass_tv_login);
        consentTV = findViewById(R.id.consent_text);
        newUserTV = findViewById(R.id.new_user);

        emailET = findViewById(R.id.email_et_login);
        passET = findViewById(R.id.pass_et_login);

        consentCheck = findViewById(R.id.consent_check);

        loginBtn = findViewById(R.id.login_btn);
    }

    //Firebase FireStore Database
    public void onClick(View v) {
        if (v.getId() == R.id.login_btn) {
            if (emailET.getText().toString().equals("")) {
                Toast.makeText(LoginActivity.this, "Please enter valid email ID", Toast.LENGTH_SHORT).show();
            } else if (passET.getText().toString().equals("")) {
                Toast.makeText(LoginActivity.this, "Please enter the correct pass", Toast.LENGTH_SHORT).show();
            }
            db.collection("users")
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot doc : task.getResult()) {
                                String a = doc.getString("Email");
                                String b = doc.getString("Password");

                                String a1 = emailET.getText().toString().trim();
                                String b1 = passET.getText().toString().trim();

                                assert a != null;
                                assert b != null;
                                if (a.equals(a1) & b.equals(b1)) {
                                    Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(mainIntent);
                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Login Failed! Please check your email and password", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
        } else if (v.getId() == R.id.new_user) {
            Intent regIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(regIntent);
        }
    }
    //Firebase FireStore Database
}