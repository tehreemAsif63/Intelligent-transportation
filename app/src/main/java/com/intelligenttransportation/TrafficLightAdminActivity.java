package com.intelligenttransportation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TrafficLightAdminActivity extends AppCompatActivity {

    public BrokerConnection broker;
    public static final String SUB_TOPIC = "group9_outTopic";

    public static final String LOCALHOST = "broker.emqx.io";
    private static final String MQTT_SERVER = "tcp://" + LOCALHOST + ":1883";
    public static final String CLIENT_ID = "Android App";
    public static final int QOS = 2;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_light_admin);

        broker = new BrokerConnection(getApplicationContext());
        mqttClient = broker.getMqttClient();
        broker.setConnectionMessage(findViewById(R.id.textView_west_east_number),
                findViewById(R.id.textView_north_south_number),
                findViewById(R.id.light_east),
                findViewById(R.id.light_west),
                findViewById(R.id.light_north),
                findViewById(R.id.light_south),
                findViewById(R.id.light_east_west),
                findViewById(R.id.light_north_south));
        broker.connectToMqttBroker();

        Button eastGo = findViewById(R.id.button_west_east);
        eastGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mqttClient.publish(PUB_TOPIC, DisplayUtils.eastGoAdmin, QOS, null);
            }
        });

        Button northGo = findViewById(R.id.button_north_south);
        northGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mqttClient.publish(PUB_TOPIC, DisplayUtils.northGoAdmin, QOS, null);
            }
        });

        Button renew = findViewById(R.id.button_renew);
        renew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mqttClient.publish(PUB_TOPIC, DisplayUtils.renewAdmin, QOS, null);
            }
        });

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