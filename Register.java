package com.example.hunaina.fistulasearchapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Register extends AppCompatActivity implements View.OnClickListener {

    private static final String REGISTER_URL = "https://fistulasearch.000webhostapp.com/register.php";

    public static final String KEY_EMAIL = "email";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_CONFIRMPASSWORD = "confirmpassword";


    private EditText etEmail;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etConfirmPassword;

    private Button bRegister;
    private TextView tvLoginLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPassword = (EditText)findViewById(R.id.etConfirmPassword);

        tvLoginLink = (TextView) findViewById(R.id.tvLoginLink);
        bRegister = (Button) findViewById(R.id.bRegister);

        tvLoginLink.setOnClickListener(this);
        bRegister.setOnClickListener(this);
    }

    private void registerUser() {
        final String email = etEmail.getText().toString().trim();
        final String username = etUsername.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();
        final String confirmpassword = etConfirmPassword.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(Register.this, response, Toast.LENGTH_LONG).show();
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Register.this, error.toString(), Toast.LENGTH_LONG).show();

                    }

                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_EMAIL, email);
                params.put(KEY_USERNAME, username);
                params.put(KEY_PASSWORD, password);
                params.put(KEY_CONFIRMPASSWORD, confirmpassword);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        if (v == bRegister) {
            registerUser();
            ClearEditTextAfterDoneTask();
            openLogin();

        } else if (v == tvLoginLink) {
            Intent intent = new Intent(Register.this, Login.class);
            startActivity(intent);
        }
    }

    public void ClearEditTextAfterDoneTask() {

        etEmail.getText().clear();
        etUsername.getText().clear();
        etPassword.getText().clear();
        etConfirmPassword.getText().clear();
    }
    private void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivityForResult(intent, 100);
    }

}


