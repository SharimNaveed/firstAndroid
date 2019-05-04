package com.doodhwaledevs.inno;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.doodhwaledevs.inno.AreaActivity.EXTRA_AREA;


public class DashboardActivity extends AppCompatActivity {

    private ImageButton Area;
    private ImageButton Doctor;
    private ImageButton Product;
    private Button Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent intent = getIntent();
        String AreaName = intent.getStringExtra(EXTRA_AREA);

        TextView DashSelectedArea = findViewById(R.id.DashSelectedArea);
        DashSelectedArea.setText(AreaName);

       Area=(ImageButton) findViewById(R.id.LocationButton);
       Doctor=(ImageButton) findViewById(R.id.DoctorButton);
       Product=(ImageButton) findViewById(R.id.ProductButton);
       Next=(Button) findViewById(R.id.NextFromDashButton);

       Area.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openLocationActivity();
           }


       });

       Doctor.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openDoctorActivity();
           }
       });

       Product.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openProductActivity();
           }
       });

       Next.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openSubmitActivity();
           }
       });
    }
    public void openLocationActivity(){
        Intent intent = new Intent(this,LocationActivity.class);
        startActivity(intent);
    }
    public void openDoctorActivity(){
        Intent intent = new Intent(this,DoctorActivity.class);
        startActivity(intent);
    }
    public void openProductActivity(){
        Intent intent = new Intent(this,ProductActivity.class);
        startActivity(intent);
    }
    public void openSubmitActivity(){
        Intent intent = new Intent(this,SubmitActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);

        builder.setTitle("Log Out")
                .setMessage("Are you sure,You want to Log Out?")
                .setPositiveButton("Log Out", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DashboardActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("Cancel",null).setCancelable(false);

        AlertDialog alert = builder.create();
        alert.show();
    }



}

