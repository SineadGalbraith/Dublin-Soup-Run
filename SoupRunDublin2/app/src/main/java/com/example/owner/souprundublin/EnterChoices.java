package com.example.owner.souprundublin;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EnterChoices extends AppCompatActivity {

    GPS gps;
    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    long amount;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_choices);
        getCurrentPos();
        textView = (TextView)findViewById(R.id.textView3);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                amount = 2;
                LocationInfo.addData(getCurrentPos(), amount);
                textView.setText("Thank you!");

            }
        });
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        button6 = (Button)findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public Location getCurrentPos()
    {
        gps = new GPS(EnterChoices.this);
        Location currentPos = new Location("Current Position");
        currentPos.setLatitude(gps.findLatitude());
        currentPos.setLongitude(gps.findLongitude());

        return currentPos;
    }





}


