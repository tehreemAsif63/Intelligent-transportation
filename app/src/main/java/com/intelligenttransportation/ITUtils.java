package com.intelligenttransportation;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ITUtils {

    //The control system uses "xxxx" four digits as a password to communicate with the Wio terminal.
    // The four digits are represented:
    //userType: 0 is no case; 1 is general user; 2 is admin user
    //whichGo: 0 is no case; 1 is east-west; 2 is north-south
    //isRenew: 1 is renew to original state
    //isExchange: 1 is immediately change the traffic light status on both sides
    public static final String eastGoUser = "1100";
    public static final String northGoUser = "1200";
    public static final String eastGoAdmin = "2100";
    public static final String northGoAdmin = "2200";
    public static final String renewAdmin = "2010";
    public static final String exchangeAdmin = "2001";

    public static TextView textView_east_number;
    public static TextView textView_north_number;
    public static ImageView imageView_east;
    public static ImageView imageView_west;
    public static ImageView imageView_north;
    public static ImageView imageView_south;
    public static ImageView imageView_east_west;
    public static ImageView imageView_north_south;
    public static ImageView imageView_car_east1;
    public static ImageView imageView_car_east2;
    public static ImageView imageView_car_north1;
    public static ImageView imageView_car_north2;
    public static TextView textView_front_distance;
    public static TextView textView_back_distance;
    public static ImageView imageView;
    public static double distance;
    public TextView warningText;



    public static void showDynamicPage(String str) {
        String[] messages = str.split(";");
        String[] firstData = messages[0].split(":");

        if (firstData[0].equals("east")){
            String[] eastData = messages[0].split(":");
            String[] northData = messages[1].split(":");
            showEastData(eastData);
            showNorthData(northData);
        } else if (firstData[0].equals("distance")) {
            String[] frontDistance = messages[0].split(":");
            String[] backDistance = messages[1].split(":");
            showFrontDistance(frontDistance);
            showBackDistance(backDistance);
        }

    }



    public static void showEastData(String[] eastData){
        switch (eastData[1]) {
            case "red":
                textView_east_number.setTextColor(Color.RED);
                imageView_east.setImageResource(R.drawable.red);
                imageView_west.setImageResource(R.drawable.red);
                imageView_east_west.setImageResource(R.drawable.red);
                break;
            case "yellow":
                textView_east_number.setTextColor(Color.YELLOW);
                imageView_east.setImageResource(R.drawable.yellow);
                imageView_west.setImageResource(R.drawable.yellow);
                imageView_east_west.setImageResource(R.drawable.yellow);
                break;
            case "green":
                textView_east_number.setTextColor(Color.GREEN);
                imageView_east.setImageResource(R.drawable.green);
                imageView_west.setImageResource(R.drawable.green);
                imageView_east_west.setImageResource(R.drawable.green);
                imageView_car_east1.setVisibility(View.GONE);
                imageView_car_east2.setVisibility(View.GONE);
                break;
            case "car":
                if (eastData[2].equals("1")){
                    imageView_car_east1.setVisibility(View.VISIBLE);
                } else if (eastData[2].equals("2")) {
                    imageView_car_east2.setVisibility(View.VISIBLE);
                }
                break;
        }
        textView_east_number.setText(eastData[2].length() < 2 ? "0" + eastData[2] : eastData[2]);
    }

    public static void showNorthData(String[] northData){
        switch (northData[1]) {
            case "red":
                textView_north_number.setTextColor(Color.RED);
                imageView_north.setImageResource(R.drawable.red);
                imageView_south.setImageResource(R.drawable.red);
                imageView_north_south.setImageResource(R.drawable.red);
                break;
            case "yellow":
                textView_north_number.setTextColor(Color.YELLOW);
                imageView_north.setImageResource(R.drawable.yellow);
                imageView_south.setImageResource(R.drawable.yellow);
                imageView_north_south.setImageResource(R.drawable.yellow);
                break;
            case "green":
                textView_north_number.setTextColor(Color.GREEN);
                imageView_north.setImageResource(R.drawable.green);
                imageView_south.setImageResource(R.drawable.green);
                imageView_north_south.setImageResource(R.drawable.green);
                imageView_car_north1.setVisibility(View.GONE);
                imageView_car_north2.setVisibility(View.GONE);
                break;
            case "car":
                if (northData[2].equals("1")){
                    imageView_car_north1.setVisibility(View.VISIBLE);
                } else if (northData[2].equals("2")) {
                    imageView_car_north2.setVisibility(View.VISIBLE);
                }
                break;
        }
        textView_north_number.setText(northData[2].length() < 2 ? "0" + northData[2] : northData[2]);
    }

    private static void showFrontDistance(String[] frontDistance) {
        textView_front_distance.setText(frontDistance[2]);
    }
    private static void showBackDistance(String[] backDistance) {
        textView_back_distance.setText(backDistance[2]);
    }

    private void updateImage() {

        if (distance > 20) {
            imageView.setImageResource(R.drawable.car); //regular
        } else if (distance < 20 && distance > 10) {
            imageView.setImageResource(R.drawable.car); //green
        } else if (distance < 10 && distance > 5) {
            imageView.setImageResource(R.drawable.car); //yellow
            warningText.setVisibility(View.VISIBLE);
        } else {
            imageView.setImageResource(R.drawable.car); //red
            warningText.setVisibility(View.VISIBLE);
        }
    }

}
