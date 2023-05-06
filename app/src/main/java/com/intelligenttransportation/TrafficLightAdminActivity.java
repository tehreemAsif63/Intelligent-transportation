package com.intelligenttransportation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TrafficLightAdminActivity extends AppCompatActivity {

    public BrokerConnection broker;
    public static final String SUB_TOPIC = "group9_outTopic";

    public static final String LOCALHOST = "broker.emqx.io";
    private static final String MQTT_SERVER = "tcp://" + LOCALHOST + ":1883";
    public static final String CLIENT_ID = "Android App";
    public static final int QOS = 0;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_light_admin);

        broker = new BrokerConnection(getApplicationContext());
        broker.setConnectionMessage(
                findViewById(R.id.textView_west_east_number),
                findViewById(R.id.textView_north_south_number),
                findViewById(R.id.light_east),
                findViewById(R.id.light_west),
                findViewById(R.id.light_north),
                findViewById(R.id.light_south),
                findViewById(R.id.light_east_west),
                findViewById(R.id.light_north_south),
                findViewById(R.id.image_car_east),
                findViewById(R.id.image_car_north)
        );
        broker.connectToMqttBroker();




        bottomNavigationView = findViewById(R.id.bottom_navigation_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                switch (item.getItemId()){
                    case R.id.navigation_car_console:
                        intent = new Intent(TrafficLightAdminActivity.this, CarConsoleActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_user:
                        intent = new Intent(TrafficLightAdminActivity.this, UserActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

    }

    public void goBack(View view){
        Intent intent = new Intent(TrafficLightAdminActivity.this, MainActivity.class);
        startActivity(intent);
    }

}