package com.intelligenttransportation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CarConsoleActivity extends AppCompatActivity {

    public BrokerConnection broker;
    private User user;

    public static final String LOCALHOST = "broker.emqx.io";
    private static final String MQTT_SERVER = "tcp://" + LOCALHOST + ":1883";
    public static final String CLIENT_ID = "Android App";
    public static final int QOS = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_console);

        broker = new BrokerConnection(getApplicationContext());
        ITUtils.textView_front_distance = findViewById(R.id.textView_distance_front);
        ITUtils.textView_back_distance = findViewById(R.id.textView_distance_back);
        ITUtils.imageView_car_background = findViewById(R.id.image_car);
        broker.connectToMqttBroker();

        user = (User) getIntent().getSerializableExtra("user");
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
                        intent = new Intent(CarConsoleActivity.this, MainActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                        break;
                    case R.id.navigation_user:
                        if (user == null){
                            intent = new Intent(CarConsoleActivity.this, LoginActivity.class);
                        }else {
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
