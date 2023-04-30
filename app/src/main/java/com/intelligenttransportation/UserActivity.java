package com.intelligenttransportation;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        bottomNavigationView = findViewById(R.id.bottom_navigation_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                switch (item.getItemId()){
                    case R.id.navigation_traffic_light:
                        intent = new Intent();
                        intent.setClass(UserActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_car_console:
                        intent = new Intent();
                        intent.setClass(UserActivity.this, CarConsoleActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

    }
}