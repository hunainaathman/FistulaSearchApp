package com.example.hunaina.fistulasearchapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Profile extends AppCompatActivity {
    public static final String GETTUSERDATA_URL = "https://fistulasearch.000webhostapp.com/getuserdetails.php";

    public static final String KEY_FIRSTNAME = "firstname";
    public static final String KEY_SECONDNAME = "secondname";
    public static final String KEY_LASTNAME = "lastname";
    public static final String KEY_NATIONALID = "national_id";
    public static final String KEY_GENDER = "ngender";
    public static final String KEY_AGE = "age";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_CONTACT = "contact";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_USERLEVEL = "user_level";
    public static final String KEY_HOSPITAL = "hospital";
    public static final String KEY_DEPARTMENT = "department";
    public static final String KEY_LOCATION = "location";
    public static final String KEY_CITY = "city";
    public static final String KEY_COUNTRY = "country";
    public static final String KEY_QUALIFICATION = "qualification";
    public static final String JSON_ARRAY = "result";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_account_circle_black_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_profile);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bNext:
                Intent intent = new Intent(Profile.this, Home.class);
                startActivity(intent);

                break;
            case R.id.bEdit:

        }
        return true;
    }
}
