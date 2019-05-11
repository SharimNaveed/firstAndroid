package com.doodhwaledevs.inno;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LocationActivity extends AppCompatActivity {

    private Button City_Button;
    private Button Area_Button;
    private Button Back;
    public  TextView AreaSelectTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        AreaSelectTV = (TextView) findViewById(R.id.AreaSelectTV);

        City_Button = (Button) findViewById(R.id.City_Button);
        Area_Button = (Button) findViewById(R.id.Area_Button);
        Back = (Button) findViewById(R.id.LocationBack);

        City_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCityActivity();
            }
        });

        Area_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAreaActivity();
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LocationActivity.this);
                builder.setTitle("Confirmation")
                        .setMessage("Confirm Selection?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                openDashboardActivity();
                            }
                        })
                        .setNegativeButton("No",null).setCancelable(false);

                AlertDialog alert = builder.create();
                alert.show();
            }


        });

    }

    public void DisplayArea(){

        SharedPreferences sharedArea = getSharedPreferences("SelectedArea", Context.MODE_PRIVATE);

        String AreaValue = sharedArea.getString("Selcted Area", "");

        AreaSelectTV.setText(AreaValue);
    }

    public void openCityActivity() {
        Intent intent = new Intent(this, CityActivity.class);
        startActivity(intent);
    }

    public void openAreaActivity() {
        Intent intent = new Intent(this, AreaActivity.class);
        startActivity(intent);
    }

    public void openDashboardActivity() {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }
}

