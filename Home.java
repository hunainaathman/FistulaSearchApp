package com.example.hunaina.fistulasearchapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import java.util.Calendar;

import android.widget.ImageView;
import android.widget.TextView;


public class Home extends AppCompatActivity implements View.OnClickListener{

    private TextView txtusername, tvDisplayDate;
    private TextView tvCompleteProfileLink;
    private ImageButton bNewDiagnoses, bDiagnosedPatient;
    private ImageView profilepic;


    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_home_black_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_home);


        txtusername = (TextView) findViewById(R.id.txtusername);
        tvCompleteProfileLink = (TextView) findViewById(R.id.tvCompleteProfileLink);
        bNewDiagnoses = (ImageButton) findViewById(R.id.bNewDiagnoses);
        bDiagnosedPatient = (ImageButton) findViewById(R.id.bDiagnosedPatient);
        profilepic = (ImageView) findViewById(R.id.profilepic);

        bNewDiagnoses.setOnClickListener(this);
        tvCompleteProfileLink.setOnClickListener(this);
        bDiagnosedPatient.setOnClickListener(this);
        profilepic.setOnClickListener(this);

        setCurrentDate();


        Intent intent = getIntent();
        txtusername.setText(intent.getStringExtra(Login.KEY_USERNAME));

}

    @Override
    public void onClick(View v) {
        if (v == bNewDiagnoses) {
            Intent intent = new Intent(Home.this, NewDiagnoses.class);
            startActivity(intent);

        } else if (v == tvCompleteProfileLink) {

            Intent intent = new Intent(Home.this, UserProfile.class);
            startActivity(intent);

        }else if (v == bDiagnosedPatient){
            Intent intent = new Intent(Home.this, DiagnosedPatient.class);
            startActivity(intent);

        }else if (v==profilepic){
            Intent intent = new Intent(Home.this, Profile.class);
            startActivity(intent);
        }
    }

    private void setCurrentDate() {
        tvDisplayDate = (TextView) findViewById(R.id.tvDate);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        tvDisplayDate.setText(new StringBuilder().append(day).append("-").
                append(month + 1).append("-").append(year).append("")
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                Intent intent = new Intent(Home.this, Login.class);
                startActivity(intent);

            break;
        }
        return true;
    }
}


























