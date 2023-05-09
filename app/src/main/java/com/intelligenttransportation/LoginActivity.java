package com.intelligenttransportation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "Login";
    // Declare login button and EditTexts
    String username, password;
    EditText usernameInput;
    EditText passwordInput;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        usernameInput = findViewById(R.id.userNameInput);
        passwordInput = findViewById(R.id.passwordInput);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setBackgroundColor(android.R.color.black);
        buttonLogin.setTextColor(android.R.color.white);
        buttonLogin.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

        // Get the username and password from the EditTexts
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();
        boolean verifyGeneralUser=Controller.verifyUserCredentials(username, password,"General user");
        boolean verifyAdmin=Controller.verifyAdminCredentials(username, password,"Admin");
        if(verifyGeneralUser==true) {
            add_information();
            // Check if the username and password are correct
            // If the user is an admin, start the AdminActivity
            Intent intent = new Intent(LoginActivity.this, UserActivity.class);
            startActivity(intent);
        } else if (verifyAdmin == true) {
            add_information();
            Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
            startActivity(intent);
        } else{
            final String wrongCredM = "Wrong Username or password!\n Try again!";
            Log.w(TAG, wrongCredM);
            Toast.makeText(getApplicationContext(), wrongCredM, Toast.LENGTH_SHORT).show();
        }
    }
    public void add_information() {
        Log.d("username", username);
        Log.d("password", password);
    }

}
