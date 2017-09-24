package com.example.hunaina.fistulasearchapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class DiagnosedPatient extends AppCompatActivity implements View.OnClickListener {
    public static final String JSON_URL = "";
    private ListView listView1;
    private AutoCompleteTextView search;
    private TextView tvid, tvfname, tvsname, tvlname;
    public static final String[]id = ParseJSON.ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_group_black);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_diagnosed_patient);

        tvid = (TextView) findViewById(R.id.tvid);
        tvfname = (TextView) findViewById(R.id.tvfname);
        tvsname = (TextView) findViewById(R.id.tvsname);
        tvlname = (TextView) findViewById(R.id.tvlname);

        listView1 = (ListView)findViewById(R.id.listView1);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = listView1.getItemAtPosition(position);

            }
        });
        search = (AutoCompleteTextView) findViewById(R.id.search);
        String[] patients = {"Amina", "Beatrace", "Caroline", "Delvine", "Esther", "Fatma", "Gilla", "Hellen", "Irene", "Janice", "Kinna", "Lorine", "Maurine", "Nancy"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, patients);
        search.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_diagnosed_patients, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.refresh){
            sendRequest();
        }

        else if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void sendRequest(){
        StringRequest stringRequest = new StringRequest(JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJSON(response);
            }
        },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DiagnosedPatient.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json){
        ParseJSON pj = new ParseJSON(json);
        pj.ParseJSON();
        ListDataAdapter ld = new ListDataAdapter(this, ParseJSON.ids, ParseJSON.firstnames, ParseJSON.secondnames, ParseJSON.lastnames);
        listView1.setAdapter(ld);

        //tvid.setText(String id);
        //tvfname.setText(ParseJSON.firstnames);
        //tvsname.setText(secondnames);
        //tvlname.setText(lastnames);
    }

    @Override
    public void onClick(View v) {
        if(v == listView1){
            Intent intent = new Intent(DiagnosedPatient.this, PatientDetails.class);
            startActivity(intent);
        }
    }
}