package com.intelligenttransportation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountActivity extends AppCompatActivity {

    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        user = (User) getIntent().getSerializableExtra("user");

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
                switch (item.getItemId()) {
                    case R.id.navigation_car_console:
                        intent = new Intent(AccountActivity.this, CarConsoleActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                        break;
                    case R.id.navigation_user:
                        intent = new Intent(AccountActivity.this, LoginActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
    }
}