package com.doodhwaledevs.truestep;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class SubmitActivity extends AppCompatActivity {
    Button btnShowLocation;
    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;

    // GPSTracker class
    GPSTracker gps;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

            try {
                if (ActivityCompat.checkSelfPermission(this, mPermission) != getPackageManager().PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(this, new String[]{mPermission},
                            REQUEST_CODE_PERMISSION);

                    // If any permission above not allowed by user, this condition wil execute every time, else your else part will work
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            btnShowLocation = (Button) findViewById(R.id.LocationButton);

            // show location button click event
            btnShowLocation.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // create class object
                    gps = new GPSTracker(SubmitActivity.this);

                    // check if GPS enabled
                    if (gps.canGetLocation()) {

                        double latitude = gps.getLatitude();
                        double longitude = gps.getLongitude();

                        // \n is for new line
                        Toast.makeText(getApplicationContext(), "Your Location is - \nLat: "
                                + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                    } else {
                        // can't get location
                        // GPS or Network is not enabled
                        // Ask user to enable GPS/network in settings
                        gps.showSettingsAlert();
                    }


                }

                public void onBackPressed() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SubmitActivity.this);

                    builder.setTitle("Cancel")
                            .setMessage("Do you want to cancel current selections?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    SubmitActivity.super.onBackPressed();
                                }
                            })
                            .setNegativeButton("No", null).setCancelable(false);

                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });
        }

}