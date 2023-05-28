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
import com.intelligenttransportation.model.User;

public class AccountActivity extends AppCompatActivity {

    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        user = (User) getIntent().getSerializableExtra("user");
        if (user.getType().equals("general")){
            ImageView headImage = findViewById(R.id.imageView_head);
            headImage.setImageResource(R.drawable.tom);
            TextView nameText = findViewById(R.id.textView_username);
            nameText.setText(R.string.tom_cat);
        } else if (user.getType().equals("admin")) {
            ImageView headImage = findViewById(R.id.imageView_head);
            headImage.setImageResource(R.drawable.police);
            TextView nameText = findViewById(R.id.textView_username);
            nameText.setText(R.string.traffic_police);
        }
        TextView bindCarText = findViewById(R.id.textView_bind_car);
        ImageView carImage = findViewById(R.id.imageView_bound_car);
        if (user.isBoundCar()){
            bindCarText.setVisibility(View.GONE);
            carImage.setImageResource(user.getCar().getImageSrc());
            carImage.setVisibility(View.VISIBLE);
        } else {
            carImage.setVisibility(View.GONE);
            bindCarText.setVisibility(View.VISIBLE);
        }

        Button buttonBind = findViewById(R.id.button_bind_car);
        Button buttonLogout = findViewById(R.id.button_logout);

        buttonBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this, BindCarActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this,LoginActivity.class);
                user = null;
                intent.putExtra("user", user);
                startActivity(intent);

            }
        });

        bottomNavigation();

    }

    public void bottomNavigation(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                switch (item.getItemId()){
                    case R.id.navigation_traffic_light:
                        intent = new Intent();
                        intent.setClass(AccountActivity.this, MainActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                        break;
                    case R.id.navigation_car_console:
                        intent = new Intent();
                        intent.setClass(AccountActivity.this, CarConsoleActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
    }
}