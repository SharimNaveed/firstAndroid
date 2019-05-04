package com.doodhwaledevs.inno;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView ForgotPassword;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etUsername);
        Password =(EditText)findViewById(R.id.etPassword);
        Login = (Button)findViewById(R.id.LoginBtn);
        ForgotPassword=(TextView)findViewById(R.id.TvForgotPass);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

        ForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browser= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.doodhwaledevs.com"));
                startActivity(browser);

            }
        });


    }

    private void validate(String userName , String userPassword)
    {
        if ((userName.equals("admin")) && (userPassword.equals("admin")))
        {
            Intent intent = new Intent(MainActivity.this , DashboardActivity.class);
            startActivity(intent);

            Toast.makeText(getApplicationContext(),"Welcome to TRUESTEP!",Toast.LENGTH_SHORT).show();

        }
    }


    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Exit")
                .setMessage("Are you sure,You want to exit?")
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("Cancel",null).setCancelable(false);

        AlertDialog alert = builder.create();
        alert.show();
    }


}

