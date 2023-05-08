package com.intelligenttransportation;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
public class LoginActivity extends AppCompatActivity {
    EditText usernameEditText;
    EditText passwordEditText;
    TextView errorTextView;
    private static final String TAG = "Login";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        errorTextView = findViewById(R.id.errorTextView);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (verifyCredentials(username, password)) {
                    // Go to the Account Information page
                    Intent intent = new Intent(LoginActivity.this, AccountInformationActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                } else {
                    final String wrongCredM = "Wrong Username or password!\n Try again!";
                    Log.w(TAG, wrongCredM);
                    Toast.makeText(getApplicationContext(), wrongCredM, Toast.LENGTH_SHORT).show();               }
            }
        });
    }

    private boolean verifyCredentials(String username, String password) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("Users.txt")));

            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }

            Type userListType = new TypeToken<List<User>>(){}.getType();
            List<User> users = new Gson().fromJson(jsonContent.toString(), userListType);

            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}