package com.example.hunaina.fistulasearchapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class NewDiagnoses extends AppCompatActivity {

    TextView section_label;
    CardView cd1, cd2, cd3, cd4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_autorenew_black_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_new_diagnoses);

        cd1 = (CardView) findViewById(R.id.cd_1);
        cd2 = (CardView) findViewById(R.id.cd_2);
        cd3 = (CardView) findViewById(R.id.cd_3);
        cd3 = (CardView) findViewById(R.id.cd_3);
        cd4 = (CardView) findViewById(R.id.cd_4);


        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cd1.getContext().startActivity(new Intent(cd1.getContext(), AddPatient.class));
            }
        });

        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cd2.getContext().startActivity(new Intent(cd2.getContext(), Fdp1.class));
            }

        });

        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cd3.getContext().startActivity(new Intent(cd3.getContext(), Recommendation.class));
            }

        });
        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cd4.getContext().startActivity(new Intent(cd3.getContext(), AssignAppointment.class));
            }

        });


    }
}
