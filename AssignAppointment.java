package com.example.hunaina.fistulasearchapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
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
import java.util.Calendar;

public class AssignAppointment extends AppCompatActivity {
    private static final String ASSIGNAPPOINTMENT_URL = "https://fistulasearch.000webhostapp.com/assignappointment.php";

    public static final String KEY_NOTES = "notes";
    public static final String KEY_TYPE = "type";
    public static final String KEY_DATE = "date";

    private DatePicker dp;
    private Spinner visittype;
    private EditText etnotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_schedule);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_assign_appointment);

        dp = (DatePicker) findViewById (R.id.datePicker);
        Calendar calendar = Calendar.getInstance();
        dp.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener(){

            @Override
            public void onDateChanged(DatePicker dp, int year, int monthOfYear, int dayOfMonth){
               String date = dp.getDayOfMonth() + "_" +dp.getMonth() + "_" +dp.getYear();
            }
        });

        visittype = (Spinner) findViewById(R.id.visittype);
        String[] vis = {"New Visit", "Follow up Visit"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, vis);
        visittype.setAdapter(adapter);
        etnotes = (EditText) findViewById (R.id.etnotes);


    }
    private void assignAppointment() {
        final String notes = etnotes.getText().toString().trim();
        final String type = visittype.getSelectedItem().toString().trim();
        final String date = dp.toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, ASSIGNAPPOINTMENT_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(AssignAppointment.this, response, Toast.LENGTH_LONG).show();
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AssignAppointment.this, error.toString(), Toast.LENGTH_LONG).show();

                    }

                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_NOTES, notes);
                params.put(KEY_TYPE, type);
                params.put(KEY_DATE, date);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    public void ClearEditTextAfterDoneTask() {
        etnotes.getText().clear();
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
                Intent intent = new Intent(AssignAppointment.this, Home.class);
                startActivity(intent);

                break;
            case R.id.bSave:
                assignAppointment();
                ClearEditTextAfterDoneTask();
        }
        return true;
    }


}
