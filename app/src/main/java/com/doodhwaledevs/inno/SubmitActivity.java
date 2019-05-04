package com.doodhwaledevs.inno;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SubmitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
    }
    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(SubmitActivity.this);

        builder.setTitle("Cancel")
                .setMessage("Do you want to cancel current selections?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SubmitActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No",null).setCancelable(false);

        AlertDialog alert = builder.create();
        alert.show();
    }

}
