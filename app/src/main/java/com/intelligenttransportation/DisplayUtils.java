package com.intelligenttransportation;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayUtils {

    public static TextView textView_east_number;
    public static TextView textView_north_number;
    public static ImageView imageView_east;
    public static ImageView imageView_west;
    public static ImageView imageView_north;
    public static ImageView imageView_south;
    public static ImageView imageView_east_west;
    public static ImageView imageView_north_south;

    public static void setViewsID(TextView textView_east, TextView textView_north, ImageView light_east,
                                  ImageView light_west,ImageView light_north,ImageView light_south,
                                  ImageView light_east_west,ImageView light_north_south){
        textView_east_number = textView_east;
        textView_north_number = textView_north;
        imageView_east = light_east;
        imageView_west = light_west;
        imageView_north = light_north;
        imageView_south = light_south;
        imageView_east_west = light_east_west;
        imageView_north_south = light_north_south;
    }

    public static void showDynamicPage(String str){
        String[] messages = str.split(";");
        String[] eastData = messages[0].split(":");
        String[] northData = messages[1].split(":");
        switch (eastData[1]){
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
                break;
        }
        textView_east_number.setText(eastData[2].length() < 2 ? "0" + eastData[2] : eastData[2]);

        switch (northData[1]){
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
                break;
        }
        textView_north_number.setText(northData[2].length() < 2 ? "0" + northData[2] : northData[2]);

    }
}
