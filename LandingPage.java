package com.example.hunaina.fistulasearchapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LandingPage extends AppCompatActivity {
    ImageView icon;
    TextView wtxtView;
    Button btnLogin, btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        icon = (ImageView) findViewById(R.id.icon);
        wtxtView = (TextView) findViewById(R.id.wtxtView);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);


    }

    public void btnLogin(View v) {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }

    public void btnRegister(View v) {
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }


}



