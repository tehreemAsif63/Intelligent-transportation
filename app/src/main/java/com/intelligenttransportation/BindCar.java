package com.intelligenttransportation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BindCar extends AppCompatActivity {

    int i =0;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_car);
        final ImageView imageView = findViewById(R.id.imageView);
        final TextView textView = findViewById(R.id.textView);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {

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
    }


}