package com.intelligenttransportation;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class UserLogin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);


        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.Password);

        MaterialButton loginButton = findViewById(R.id.loginButton);


        loginButton.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v) {

            String selectUsername = username.getText().toString();
            String selectPassword = password.getText().toString();

            Toast.makeText(UserLogin.this, "Your account is logged in successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}