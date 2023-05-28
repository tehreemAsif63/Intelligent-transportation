package com.intelligenttransportation.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.intelligenttransportation.R;

public class SplashScreen extends AppCompatActivity {

    TextView appName,appName2;
    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        animationView =findViewById(R.id.animationView);
        appName= findViewById(R.id.appName);
        appName2 = findViewById(R.id.appName2);

        animationView.animate().translationY(2500).setDuration(2500).setStartDelay(2500);
        appName.animate().translationY(2500).setDuration(2500).setStartDelay(2500);
        appName2.animate().translationY(2500).setDuration(2500).setStartDelay(2500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        },5000);
    }


}