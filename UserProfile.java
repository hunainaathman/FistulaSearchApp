package com.example.hunaina.fistulasearchapp;

import android.content.Intent;
import android.os.AsyncTask;
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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


public class UserProfile extends AppCompatActivity{

    private static final String USERDETAILS_URL = "https://fistulasearch.000webhostapp.com/senduserdetails.php";

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



    private EditText etFname;
    private EditText etSname;
    private EditText etLname;
    private EditText etNid;
    private Spinner gender;
    private EditText etAge;
    private EditText etEmail;
    private EditText etContact;
    private EditText etUsername;
    private EditText etPassword;
    private Spinner spUserlevel;
    private EditText etHospital;
    private EditText etDepartment;
    private EditText etLocation;
    private EditText etCity;
    private Spinner spCountry;
    private Spinner qua;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_account_box_black_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_user_profile);


        etFname = (EditText) findViewById(R.id.etFname);
        etSname = (EditText) findViewById(R.id.etSname);
        etLname = (EditText) findViewById(R.id.etLname);
        etNid = (EditText) findViewById(R.id.etNid);
        gender = (Spinner) findViewById(R.id.gender);
        String[] gen = {"Male", "Female"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, gen);
        gender.setAdapter(adapter);
        etAge = (EditText) findViewById(R.id.etAge);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etContact = (EditText) findViewById(R.id.etContact);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        spUserlevel = (Spinner) findViewById(R.id.spUserlevel);
        String[] levels = {"- - - - - - - - - - - - - - - - - -", "Doctor", "Nurse", "Community Health Worker"};
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, levels);
        spUserlevel.setAdapter(adapter);
        etHospital = (EditText) findViewById(R.id.etHospital);
        etDepartment = (EditText) findViewById(R.id.etDepartment);
        etLocation = (EditText) findViewById(R.id.etLocation);
        etCity = (EditText) findViewById(R.id.etCity);
        spCountry = (Spinner) findViewById(R.id.spCountry);
        String[] countries = {"- - - - - - - - - - - - - - - - - -", "Burundi", "Ethopia", "Kenya",  "Rwanda", "Sudan", "Tanzania", "Uganda"};
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, countries);
        spCountry.setAdapter(adapter);
        qua = (Spinner) findViewById(R.id.qua);
        String[] qu = {"None", "Fistula Trained", "Fistula Surgeon"};
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, qu);
        qua.setAdapter(adapter);

    }


    public void Saveuserinfo() {
        final String firstname = etFname.getText().toString().trim();
        final String secondname = etSname.getText().toString().trim();
        final String lastname = etLname.getText().toString().trim();
        final String national_id = etNid.getText().toString().trim();
        final String ngender = gender.getSelectedItem().toString().trim();
        final String age = etAge.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();
        final String contact = etContact.getText().toString().trim();
        final String username = etUsername.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();
        final String user_level = spUserlevel.getSelectedItem().toString().trim();
        final String hospital = etHospital.getText().toString().trim();
        final String department = etDepartment.getText().toString().trim();
        final String location = etLocation.getText().toString().trim();
        final String city = etCity.getText().toString().trim();
        final String country = spCountry.getSelectedItem().toString().trim();
        final String qualification = qua.getSelectedItem().toString().trim();



        StringRequest stringRequest = new StringRequest(Request.Method.POST, USERDETAILS_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(UserProfile.this, response, Toast.LENGTH_LONG).show();
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UserProfile.this, error.toString(), Toast.LENGTH_LONG).show();

                    }

                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_FIRSTNAME, firstname);
                params.put(KEY_SECONDNAME, secondname);
                params.put(KEY_LASTNAME, lastname);
                params.put(KEY_NATIONALID, national_id);
                params.put(KEY_GENDER, ngender );
                params.put(KEY_AGE, age);
                params.put(KEY_EMAIL, email);
                params.put(KEY_CONTACT, contact);
                params.put(KEY_USERNAME, username);
                params.put(KEY_PASSWORD, password);
                params.put(KEY_USERLEVEL, user_level);
                params.put(KEY_HOSPITAL, hospital);
                params.put(KEY_DEPARTMENT, department);
                params.put(KEY_LOCATION, location);
                params.put(KEY_CITY, city);
                params.put(KEY_COUNTRY, country);
                params.put(KEY_QUALIFICATION, qualification );
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void ClearEditTextAfterDoneTask() {
        etFname.getText().clear();
        etSname.getText().clear();
        etLname.getText().clear();
        etNid.getText().clear();
        etAge.getText().clear();
        etEmail.getText().clear();
        etContact.getText().clear();
        etUsername.getText().clear();
        etPassword.getText().clear();
        etHospital.getText().clear();
        etDepartment.getText().clear();
        etLocation.getText().clear();
        etCity.getText().clear();


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
                Intent intent = new Intent(UserProfile.this, Home.class);
                startActivity(intent);

                break;
            case R.id.bSave:
                Saveuserinfo();
                ClearEditTextAfterDoneTask();
        }
        return true;
    }

}

