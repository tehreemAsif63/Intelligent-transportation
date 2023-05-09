package com.intelligenttransportation;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button viewLightButton = findViewById(R.id.button_view_light);
        viewLightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TrafficLightActivity.class);
                startActivity(intent);
            }
        });


        bottomNavigationView = findViewById(R.id.bottom_navigation_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                switch (item.getItemId()) {
                    case R.id.navigation_car_console:
                        intent = new Intent(MainActivity.this, CarConsoleActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_user:
                        intent = new Intent(MainActivity.this, UserActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

    }
}