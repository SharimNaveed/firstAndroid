package com.doodhwaledevs.inno;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.doodhwaledevs.inno.AreaActivity.EXTRA_AREA;

public class LocationActivity extends AppCompatActivity {

    private Button City_Button;
    private Button Area_Button;
    private Button Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

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

        Intent intent = getIntent();
        String AreaName = intent.getStringExtra(EXTRA_AREA);

        TextView SelectedArea = findViewById(R.id.AreaSelectTV);
        SelectedArea.setText(AreaName);
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

