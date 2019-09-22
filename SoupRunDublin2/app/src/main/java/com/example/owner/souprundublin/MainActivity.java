package com.example.owner.souprundublin;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.mock.MockPackageManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnMove;
    Button btnEnterAmounts;
    TextView txtLatLong;
    private static final int REQUEST_CODE_PERMISSON = 2;
    String permission = Manifest.permission.ACCESS_FINE_LOCATION;

    GPS gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try{
            if(ActivityCompat.checkSelfPermission(this, permission) != MockPackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this,new String[]{permission},REQUEST_CODE_PERMISSON);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

//        btnLocation = (Button)findViewById(R.id.btn_location);
//        btnLocation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                gps = new GPS(MainActivity.this);
//                txtLatLong = (TextView) findViewById(R.id.txtLatLong);
//                if(gps.canGetLocation())
//                {
//                    double latitude = gps.findLatitude();
//                    double longitude = gps.findLongitude();
//                    txtLatLong.setText("Latitude: " + latitude+", Longitude: " + longitude);
//                }
//                else
//                {
//                    gps.showAlert();
//                }
//            }
//        });

        btnMove = (Button)findViewById(R.id.btn_Move);
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, LocationDisplay.class));
            }
        });

        btnEnterAmounts = (Button)findViewById(R.id.btn_EnterAmount);
        btnEnterAmounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EnterChoices.class));
            }
        });
    }
}
