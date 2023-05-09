package com.intelligenttransportation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccountInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_information);

        Button buttonBack = findViewById(R.id.button_back);
        Button buttonBind = findViewById(R.id.button_bind);
        Button buttonLogout = findViewById(R.id.button_logout);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });


        buttonBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountInformation.this,bindCar.class);
                startActivity(intent);
            }
        });
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(user_infor.this,bindCar1.class);
                startActivity(intent);*/

            }
        });





    }
}