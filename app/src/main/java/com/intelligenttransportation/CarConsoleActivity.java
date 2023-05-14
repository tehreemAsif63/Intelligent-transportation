package com.intelligenttransportation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.view.View;
import android.widget.Button;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;

public class CarConsoleActivity extends AppCompatActivity {

    public BrokerConnection broker;
    public static final String LOCALHOST = "broker.emqx.io";
    private static final String MQTT_SERVER = "tcp://" + LOCALHOST + ":1883";
    public static final String CLIENT_ID = "Android App";
    public static final int QOS = 0;
    private BottomNavigationView bottomNavigationView;
    public MqttClient mqttClient;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_console);

        broker = new BrokerConnection(getApplicationContext());
        ITUtils.textView_front_distance = findViewById(R.id.textView_distance_front);
        ITUtils.textView_back_distance = findViewById(R.id.textView_distance_back);
        broker.connectToMqttBroker();
        bottomNavigationView = findViewById(R.id.bottom_navigation_menu);
        mqttClient = broker.getMqttClient();
        broker.connectToMqttBroker();

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            boolean isBuzzerOn = false;
            @Override
            public void onClick(View view) {
                String pubTopic = "BuzzerButtonCommand";
                if (isBuzzerOn) {
                    // code to stop the buzzer
                    String payload = "stopBuzzer"; //means stop
                    int qos = CarConsoleActivity.QOS;
                    mqttClient.publish(pubTopic, payload, qos, null);
                    isBuzzerOn = false;
                } else {
                    // code to start the buzzer
                    String payload = "playBuzzer"; //means play
                    int qos = CarConsoleActivity.QOS;
                    mqttClient.publish(pubTopic, payload, qos, null);
                    isBuzzerOn = true;
                }
            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                switch (item.getItemId()){
                    case R.id.navigation_traffic_light:
                        intent = new Intent();
                        intent.setClass(CarConsoleActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_user:
                        intent = new Intent();
                        intent.setClass(CarConsoleActivity.this, LoginActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
    }
}
