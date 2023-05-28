package com.intelligenttransportation.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.intelligenttransportation.R;
import com.intelligenttransportation.model.Car;
import com.intelligenttransportation.model.User;

public class BindCarActivity extends AppCompatActivity {

    private User user;
    private Car car;
    private int carNumber = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_car);

        user = (User) getIntent().getSerializableExtra("user");
        car = new Car(1, R.string.ferrari, R.drawable.image_ferrari_car);

        final ImageView imageView = findViewById(R.id.imageView);
        final TextView textView = findViewById(R.id.textView);
        Button backButton = findViewById(R.id.button_back);
        Button nextButton = findViewById(R.id.button_next);
        Button bindButton = findViewById(R.id.button_bind);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(BindCarActivity.this, AccountActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                carNumber++;
                switch (carNumber) {
                    case 0:
                        imageView.setImageResource(R.drawable.image_ferrari_car);
                        textView.setText(R.string.ferrari);
                        car.setImageSrc(R.drawable.image_ferrari_car);
                        car.setName(R.string.ferrari);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.image_police_car);
                        textView.setText(R.string.police_car);
                        car.setImageSrc(R.drawable.image_police_car);
                        car.setName(R.string.police_car);
                        carNumber = -1;
                        break;
                }
            }
        });

        bindButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(BindCarActivity.this, AccountActivity.class);
                user.setCar(car);
                user.setBoundCar(true);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

        bottomNavigation();
    }

    public void bottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                switch (item.getItemId()) {
                    case R.id.navigation_traffic_light:
                        intent = new Intent();
                        intent.setClass(BindCarActivity.this, MainActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                        break;
                    case R.id.navigation_car_console:
                        intent = new Intent();
                        intent.setClass(BindCarActivity.this, CarConsoleActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
    }

}