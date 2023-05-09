package com.intelligenttransportation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TrafficLightActivity extends AppCompatActivity {

    public BrokerConnection broker;
    public MqttClient mqttClient;
    public static final String PUB_TOPIC = "group9_inTopic";

    public static final String LOCALHOST = "broker.emqx.io";
    private static final String MQTT_SERVER = "tcp://" + LOCALHOST + ":1883";
    public static final String CLIENT_ID = "Android App";
    public static final int QOS = 2;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_light);

        if (0 == 0){ // If user is admin user
            Button exchangeButton = findViewById(R.id.button_exchange);
            exchangeButton.setVisibility(View.VISIBLE);
            Button renewButton = findViewById(R.id.button_renew);
            renewButton.setVisibility(View.VISIBLE);
        }

        broker = new BrokerConnection(getApplicationContext());
        ITUtils.textView_east_number = findViewById(R.id.textView_west_east_number);
        ITUtils.textView_north_number = findViewById(R.id.textView_north_south_number);
        ITUtils.imageView_east = findViewById(R.id.light_east);
        ITUtils.imageView_west = findViewById(R.id.light_west);
        ITUtils.imageView_north = findViewById(R.id.light_north);
        ITUtils.imageView_south = findViewById(R.id.light_south);
        ITUtils.imageView_east_west = findViewById(R.id.light_east_west);
        ITUtils.imageView_north_south = findViewById(R.id.light_north_south);
        ITUtils.imageView_car_east1 = findViewById(R.id.image_car_east1);
        ITUtils.imageView_car_east2 = findViewById(R.id.image_car_east2);
        ITUtils.imageView_car_north1 = findViewById(R.id.image_car_north1);
        ITUtils.imageView_car_north2 = findViewById(R.id.image_car_north2);
        mqttClient = broker.getMqttClient();
        broker.connectToMqttBroker();

        Button eastGo = findViewById(R.id.button_west_east);
        eastGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mqttClient.publish(PUB_TOPIC, ITUtils.eastGoAdmin, QOS, null);
            }
        });

        Button northGo = findViewById(R.id.button_north_south);
        northGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mqttClient.publish(PUB_TOPIC, ITUtils.northGoAdmin, QOS, null);
            }
        });

        Button renew = findViewById(R.id.button_renew);
        renew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mqttClient.publish(PUB_TOPIC, ITUtils.renewAdmin, QOS, null);
            }
        });

        Button exchange = findViewById(R.id.button_exchange);
        exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mqttClient.publish(PUB_TOPIC, ITUtils.exchangeAdmin, QOS, null);
            }
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                switch (item.getItemId()){
                    case R.id.navigation_car_console:
                        intent = new Intent(TrafficLightActivity.this, CarConsoleActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_user:
                        intent = new Intent(TrafficLightActivity.this, UserActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

    }

    public void goBack(View view){
        Intent intent = new Intent(TrafficLightActivity.this, MainActivity.class);
        startActivity(intent);
    }

}