package com.example.hunaina.fistulasearchapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hunaina.fistulasearchapp.Fdp8;
import com.example.hunaina.fistulasearchapp.R;
import com.example.hunaina.fistulasearchapp.Recommendation;

import java.util.HashMap;
import java.util.Map;

public class Fdp9 extends AppCompatActivity implements View.OnClickListener {
    private static final String FDP9_URL = "https://fistulasearch.000webhostapp.com/fdp9.php";

    public static final String KEY_RESULTS9 = "results9";

    private Button bNo, bYes;
    private CardView cd9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fdp9);

        cd9 = (CardView) findViewById(R.id.cd9);
        bNo = (Button) findViewById(R.id.bNo);
        bYes = (Button) findViewById(R.id.bYes);



        bNo.setOnClickListener(this);
        bYes.setOnClickListener(this);

    }
    private void yes(){
        final String results9 = "More Complex Obstetric Fistula Surgery and Rehabilitation required Urgently.";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, FDP9_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(Fdp9.this, response, Toast.LENGTH_LONG).show();
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Fdp9.this, error.toString(), Toast.LENGTH_LONG).show();

                    }

                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_RESULTS9, results9);
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
            Intent intent = new Intent(Fdp9.this, Recommendation.class);
            startActivity(intent);

        } else if (v == bNo) {
            Intent intent = new Intent(Fdp9.this, Recommendation.class);
            startActivity(intent);
        }
    }
}

