package com.example.hunaina.fistulasearchapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Recommendation extends AppCompatActivity {
    private static final String RECOMMENDATION_URL = "https://fistulasearch.000webhostapp.com/recommendation.php";

    public static final String KEY_RECOMMEND = "recommend";
    public static final String KEY_TYPE = "types";

    private Spinner type;
    private EditText etRecommend;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_recommendations);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_recommendation);

        type = (Spinner) findViewById(R.id.type);
        String[] types = {" - - - - - - - -", "Vesico-Vaginal Fistula", "Utero-Vaginal Fistula", "Vesico-Uterine Fistula", "Uretero-Vaginal Fistula", "Recto-Vaginal Fistula"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, types);
        type.setAdapter(adapter);
        etRecommend = (EditText) findViewById(R.id.etRecommend);

    }

    private void recommend() {
        final String recommend = etRecommend.getText().toString().trim();
        final String types = type.getSelectedItem().toString().trim();



        StringRequest stringRequest = new StringRequest(Request.Method.POST, RECOMMENDATION_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(Recommendation.this, response, Toast.LENGTH_LONG).show();
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Recommendation.this, error.toString(), Toast.LENGTH_LONG).show();

                    }

                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_RECOMMEND, recommend);
                params.put(KEY_TYPE, types);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



    public void ClearEditTextAfterDoneTask() {

        etRecommend.getText().clear();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.addpatient, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bNext:
                Intent intent = new Intent(Recommendation.this, AssignAppointment.class);
                startActivity(intent);

                break;
            case R.id.bSave:
                recommend();
                ClearEditTextAfterDoneTask();
        }
        return true;
    }

    }