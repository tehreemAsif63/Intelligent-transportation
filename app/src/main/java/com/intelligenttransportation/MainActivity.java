package com.intelligenttransportation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button userB,autoMobileConsoleB,trafficLightB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button userB= findViewById(R.id.userButton);
        Button autoMobileConsoleB= findViewById(R.id.autoMoConButton);
        Button trafficLightB= findViewById(R.id.trafficLightButton);


        //Create the users objects
        Controller.addUser("Jessei","1234","Admin");
        Controller.addUser("Elif","1234", "Admin");
        Controller.addUser("Tehreem","1234","General user");
        Controller.addUser("YenigChao","1234","General user");
        Controller.addUser("Hasson","1234", "General user");

        userB.setOnClickListener(this);
        autoMobileConsoleB.setOnClickListener(this);
        trafficLightB.setOnClickListener(this);
    }
    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.userButton:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.autoMoConButton:
                Intent intent2 = new Intent(this, UserActivity.class);
                startActivity(intent2);
                break;
            case R.id.trafficLightButton:
                Intent intent3 = new Intent(this, TrafficLightActivity.class);
                startActivity(intent3);
                break;


        }
    }
}