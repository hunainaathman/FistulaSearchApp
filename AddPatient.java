package com.example.hunaina.fistulasearchapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddPatient extends AppCompatActivity {

    private static final String PATIENTDETAILS_URL = "https://fistulasearch.000webhostapp.com/addpatient.php";

    public static final String KEY_FIRSTNAME = "firstname";
    public static final String KEY_SECONDNAME = "secondname";
    public static final String KEY_LASTNAME = "lastname";
    public static final String KEY_NATIONALID = "national_id";
    public static final String KEY_AGE = "age";
    public static final String KEY_PHONENO1 = "phoneno1";
    public static final String KEY_PHONENO2 = "phoneno2";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_LOCATION = "location";
    public static final String KEY_CITY = "city";
    public static final String KEY_COUNTRY = "country";
    public static final String KEY_NEARESTHEALTHCENTER = "nearesthealthcenter";
    public static final String KEY_MARITALSTATUS = "marital_status";
    public static final String KEY_NFIRSTNAME = "nfirstname";
    public static final String KEY_NLASTNAME = "nlastname";
    public static final String KEY_NCONTACT = "ncontact";
    public static final String KEY_GENDER = "ngender";
    public static final String KEY_NAGE = "nage";
    public static final String KEY_NRELATIONSHIP = "nrship";

    private EditText etpFname;
    private EditText etpSname;
    private EditText etpLname;
    private EditText etpNid;
    private EditText etpAge;
    private EditText etpPhoneno1;
    private EditText etpPhoneno2;
    private EditText etpEmail;
    private EditText etpLocation;
    private EditText etpCity;
    private Spinner spCountry;
    private EditText etpHcenter;
    private Spinner spMaritalStatus;
    private EditText etnFname;
    private EditText etnLname;
    private EditText etnContact;
    private Spinner gender;
    private EditText etnAge;
    private EditText etnRelationship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_add_patient);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_addpatient);

        etpFname = (EditText) findViewById(R.id.etpFname);
        etpSname = (EditText) findViewById(R.id.etpSname);
        etpLname = (EditText) findViewById(R.id.etpLname);
        etpNid = (EditText) findViewById(R.id.etpNid);
        etpAge = (EditText) findViewById(R.id.etpAge);
        etpPhoneno1 = (EditText) findViewById(R.id.etpPhoneno1);
        etpPhoneno2 = (EditText) findViewById(R.id.etpPhoneno2);
        etpEmail = (EditText) findViewById(R.id.etpEmail);
        etpLocation = (EditText) findViewById(R.id.etpLocation);
        etpCity = (EditText) findViewById(R.id.etpCity);
        spCountry = (Spinner) findViewById(R.id.spCountry);
        String[] countries = {"- - - - - - - - - - - - - - -", "Burundi", "Ethopia", "Kenya",  "Rwanda", "Sudan", "Tanzania", "Uganda"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, countries);
        spCountry.setAdapter(adapter);
        etpHcenter = (EditText) findViewById(R.id.etpHcenter);
        spMaritalStatus = (Spinner) findViewById(R.id.spMaritalStatus);
        String[] status = {" - - - - - - - - - - - - -", "Married", "Divorced", "Single"};
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, status);
        spMaritalStatus.setAdapter(adapter);
        etnFname = (EditText) findViewById(R.id.etnFname);
        etnLname = (EditText) findViewById(R.id.etnLname);
        etnContact = (EditText) findViewById(R.id.etnContact);
        gender = (Spinner) findViewById(R.id.gender);
        String[] gen = {"Male", "Female"};
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, gen);
        gender.setAdapter(adapter);
        etnAge = (EditText) findViewById(R.id.etnAge);
        etnRelationship = (EditText) findViewById(R.id.etnRelationship);

    }
    public void Savepatientinfo() {
        final String firstname = etpFname.getText().toString().trim();
        final String secondname = etpSname.getText().toString().trim();
        final String lastname = etpLname.getText().toString().trim();
        final String national_id = etpNid.getText().toString().trim();
        final String age = etpAge.getText().toString().trim();
        final String phoneno1 = etpPhoneno1.getText().toString().trim();
        final String phoneno2 = etpPhoneno2.getText().toString().trim();
        final String email = etpEmail.getText().toString().trim();
        final String location = etpLocation.getText().toString().trim();
        final String city = etpCity.getText().toString().trim();
        final String country = spCountry.toString().trim();
        final String nearesthealthcenter = etpHcenter.getText().toString().trim();
        final String marital_status = spMaritalStatus.getSelectedItem().toString().trim();
        final String nfirstname = etnFname.getText().toString().trim();
        final String nlastname = etnLname.getText().toString().trim();
        final String ncontact = etnContact.getText().toString().trim();
        final String ngender = gender.getSelectedItem().toString().trim();
        final String nage = etnAge.getText().toString().trim();
        final String nrship = etnRelationship.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, PATIENTDETAILS_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(AddPatient.this, response, Toast.LENGTH_LONG).show();
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddPatient.this, error.toString(), Toast.LENGTH_LONG).show();

                    }

                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_FIRSTNAME, firstname);
                params.put(KEY_SECONDNAME, secondname);
                params.put(KEY_LASTNAME, lastname);
                params.put(KEY_NATIONALID, national_id);
                params.put(KEY_AGE, age);
                params.put(KEY_PHONENO1, phoneno1);
                params.put(KEY_PHONENO2, phoneno2);
                params.put(KEY_EMAIL, email);
                params.put(KEY_LOCATION, location);
                params.put(KEY_CITY, city);
                params.put(KEY_COUNTRY, country);
                params.put(KEY_NEARESTHEALTHCENTER,nearesthealthcenter);
                params.put(KEY_MARITALSTATUS, marital_status);
                params.put(KEY_NFIRSTNAME, nfirstname);
                params.put(KEY_NLASTNAME, nlastname);
                params.put(KEY_NCONTACT, ncontact);
                params.put(KEY_GENDER, ngender);
                params.put(KEY_NAGE, nage);
                params.put(KEY_NRELATIONSHIP, nrship);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
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
                Intent intent = new Intent(AddPatient.this, Fdp1.class);
                startActivity(intent);

                break;
            case R.id.bSave:

                Savepatientinfo();
                ClearEditTextAfterDoneTask();
        }
        return true;
    }

    public void ClearEditTextAfterDoneTask() {
        etpFname.getText().clear();
        etpSname.getText().clear();
        etpLname.getText().clear();
        etpNid.getText().clear();
        etpAge.getText().clear();
        etpPhoneno1.getText().clear();
        etpPhoneno2.getText().clear();
        etpEmail.getText().clear();
        etpLocation.getText().clear();
        etpCity.getText().clear();
        etpHcenter.getText().clear();
        etnFname.getText().clear();
        etnLname.getText().clear();
        etnContact.getText().clear();
        etnAge.getText().clear();
        etnRelationship.getText().clear();

    }

    }
