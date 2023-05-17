package com.intelligenttransportation;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CarConsoleActivity extends AppCompatActivity {

    public BrokerConnection broker;
    public MqttClient mqttClient;
    public static final String PUB_TOPIC = "group9_inTopic";
    private User user;

    public static final String LOCALHOST = "broker.emqx.io";
    private static final String MQTT_SERVER = "tcp://" + LOCALHOST + ":1883";
    public static final String CLIENT_ID = "Android App";
    public static final int QOS = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_console);

        user = (User) getIntent().getSerializableExtra("user");
        if (user == null || !user.isBoundCar()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(CarConsoleActivity.this);
            builder.setTitle("Information")
                    .setMessage("You must bind a car in your account.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = null;
                            if (user == null) {
                                intent = new Intent(CarConsoleActivity.this, LoginActivity.class);
                            } else {
                                intent = new Intent(CarConsoleActivity.this, AccountActivity.class);
                            }
                            intent.putExtra("user", user);
                            startActivity(intent);
                        }
                    })
                    .setCancelable(false)
                    .create()
                    .show();
        } else {
            broker = new BrokerConnection(getApplicationContext());
            ITUtils.textView_front_distance = findViewById(R.id.textView_distance_front);
            ITUtils.textView_back_distance = findViewById(R.id.textView_distance_back);
            ITUtils.imageView_car_background = findViewById(R.id.image_car);
            mqttClient = broker.getMqttClient();
            broker.connectToMqttBroker();

            Button alarmButton = findViewById(R.id.button_alarm);
            alarmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mqttClient.publish(PUB_TOPIC, ITUtils.policeAlarm, QOS, null);
                }
            });

            bottomNavigation();
        }
    }

    public void bottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                switch (item.getItemId()) {
                    case R.id.navigation_traffic_light:
                        intent = new Intent(CarConsoleActivity.this, MainActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                        break;
                    case R.id.navigation_user:
                        if (user == null) {
                            intent = new Intent(CarConsoleActivity.this, LoginActivity.class);
                        } else {
                            intent = new Intent(CarConsoleActivity.this, AccountActivity.class);
                        }
                        intent.putExtra("user", user);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
    }
}
