package com.intelligenttransportation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AccountInformationActivity extends AppCompatActivity {
    TextView welcomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_information);

        welcomeTextView = findViewById(R.id.welcomeTextView);

        String username = getIntent().getStringExtra("username");
        welcomeTextView.setText("Welcome, " + username);
    }
}
