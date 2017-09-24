package com.example.hunaina.fistulasearchapp;

import android.content.Intent;
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

public class ResetPassword extends AppCompatActivity implements View.OnClickListener {
    public static final String RESETPWD_URL = "https://fistulasearch.000webhostapp.com/resetpassword.php";

    public static final String KEY_NEWPWD = "newpassword";
    public static final String KEY_REENTERPWD = "reenterpassword";

    private EditText newpwd;
    private EditText reenterpwd;
    private Button bReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_lock_open_black_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_reset_password);

        newpwd  = (EditText) findViewById(R.id.newpwd);
        reenterpwd  = (EditText) findViewById(R.id.reenterpwd);
        bReset = (Button) findViewById(R.id.bReset);

        bReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == bReset){
            reset();
        }
    }

    private void reset() {
        final String newpassword = newpwd.getText().toString().trim();
        final String reenterpassword = reenterpwd.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, RESETPWD_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (response.trim().equals("Completed Successfully")) {
                    openLogin();
                } else {
                    Toast.makeText(ResetPassword.this, response, Toast.LENGTH_LONG).show();
                }
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ResetPassword.this, error.toString(), Toast.LENGTH_LONG).show();

                    }

                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_NEWPWD, newpassword);
                params.put(KEY_REENTERPWD, reenterpassword);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private void openLogin(){
        Intent intent = new Intent(this, Login.class);
        startActivityForResult(intent, 100);

    }

}

