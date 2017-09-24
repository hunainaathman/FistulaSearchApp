package com.example.hunaina.fistulasearchapp;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Forgot extends AppCompatActivity implements View.OnClickListener {

    public static final String FORGOTPWD_URL = "https://fistulasearch.000webhostapp.com/forgotpassword.php";

    public static final String KEY_EMAIL = "email";

    private EditText emailaddress;
    private Button bSend;
    private boolean email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_lock_outline_black_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_forgot);

        emailaddress = (EditText) findViewById(R.id.emailaddress);
        bSend = (Button) findViewById(R.id.bSend);

        bSend.setOnClickListener(this);
    }

    private void Search() {
        final String email = emailaddress.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, FORGOTPWD_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (response.trim().equals("Your Email has been verified Successfully")) {
                    openResetPwd();
                } else {
                    Toast.makeText(Forgot.this, response, Toast.LENGTH_LONG).show();
                }
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Forgot.this, error.toString(), Toast.LENGTH_LONG).show();

                    }

                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_EMAIL, email);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private void openResetPwd() {
        Intent intent = new Intent(this, ResetPassword.class);
        intent.putExtra(KEY_EMAIL, email);
        startActivityForResult(intent, 100);

    }

    @Override
    public void onClick(View v) {
        if (v == bSend) {
            Search();

        }
    }
}

