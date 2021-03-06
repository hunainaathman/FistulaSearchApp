package com.example.hunaina.fistulasearchapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hunaina on 4/3/2017.
 */

public class Fdp8 extends AppCompatActivity implements View.OnClickListener {
    private static final String FDP8_URL = "https://fistulasearch.000webhostapp.com/fdp8.php";

    public static final String KEY_RESULTS8 = "results8";

    private Button bNo, bYes;
    private CardView cd8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fdp8);


        cd8 = (CardView) findViewById(R.id.cd8);
        bNo = (Button) findViewById(R.id.bNo);
        bYes = (Button) findViewById(R.id.bYes);


        bNo.setOnClickListener(this);
        bYes.setOnClickListener(this);
    }
    private void yes(){
        final String results8 = "More Complex Obstetric Fistula Surgery and Rehabilitation required Urgently.";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, FDP8_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(Fdp8.this, response, Toast.LENGTH_LONG).show();
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Fdp8.this, error.toString(), Toast.LENGTH_LONG).show();

                    }

                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_RESULTS8, results8);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



    @Override
    public void onClick (View v){
        if (v == bYes) {
            yes();
            Intent intent = new Intent(Fdp8.this, Fdp9.class);
            startActivity(intent);

        } else if (v == bNo) {

            Intent intent = new Intent(Fdp8.this, Fdp9.class);
            startActivity(intent);

        }
    }
}

