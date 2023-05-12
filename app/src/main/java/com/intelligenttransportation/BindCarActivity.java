package com.intelligenttransportation;

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

public class BindCarActivity extends AppCompatActivity {

    private User user;
    int i =0;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_car);

        user = (User) getIntent().getSerializableExtra("user");
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
                i ++;

                if (i % 2 == 0) {
                    imageView.setImageResource(R.mipmap.image_car1);
                    textView.setText(R.string.information_o);
                } else {
                    imageView.setImageResource(R.mipmap.image_car2);
                    textView.setText(R.string.information_w);
                }


            }
                /*switch (i) {
                    case 0:
                        imageView.setImageResource(R.mipmap.origion);
                        textView.setText(R.string.information_o);
                        i++;
                        break;
                    case 0:
                        imageView.setImageResource(R.mipmap.white_car1);
                        textView.setText(R.string.information_w);
                        Toast.makeText(bindCar.this, "This is last one!", Toast.LENGTH_SHORT).show();
                        i++;
                        break;
                    case 2:
                        Toast.makeText(bindCar.this, "This is last one!", Toast.LENGTH_SHORT).show();
                }*/

        });

        bindButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(BindCarActivity.this, AccountActivity.class);
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