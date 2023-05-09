package com.intelligenttransportation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BindCarActivity extends AppCompatActivity {

    int i =0;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_car);
        final ImageView imageView = findViewById(R.id.imageView);
        final TextView textView = findViewById(R.id.textView);
        Button backButton = findViewById(R.id.button_back);
        Button nextButton = findViewById(R.id.button_next);
        Button bindButton = findViewById(R.id.button_bind);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(BindCarActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                i ++;

                if (i % 2 == 0) {
                    imageView.setImageResource(R.mipmap.image_car1);
                    textView.setText(R.string.information_o);
                } else {
                    imageView.setImageResource(R.mipmap.image_car2);
                    textView.setText(R.string.information_w);
                }


            }
                /*switch (i) {
                    case 0:
                        imageView.setImageResource(R.mipmap.origion);
                        textView.setText(R.string.information_o);
                        i++;
                        break;
                    case 0:
                        imageView.setImageResource(R.mipmap.white_car1);
                        textView.setText(R.string.information_w);
                        Toast.makeText(bindCar.this, "This is last one!", Toast.LENGTH_SHORT).show();
                        i++;
                        break;
                    case 2:
                        Toast.makeText(bindCar.this, "This is last one!", Toast.LENGTH_SHORT).show();
                }*/

        });

        bindButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(BindCarActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });
    }


}