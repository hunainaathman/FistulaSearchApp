package com.example.hunaina.fistulasearchapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements View.OnClickListener{

    public static final String LOGIN_URL = "https://fistulasearch.000webhostapp.com/login.php";

    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";

    private EditText etUsername;
    private EditText etPassword;
    private Button bLogin;
    private TextView tvRegisterLink;
    private TextView tvForgotPasswordLink;

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);

        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        tvForgotPasswordLink = (TextView) findViewById(R.id.tvForgotPasswordLink);
        bLogin = (Button) findViewById(R.id.bLogin);


        bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);
        tvForgotPasswordLink.setOnClickListener(this);
    }

    private void userLogin() {
        username = etUsername.getText().toString().trim();
        password = etPassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("You Have Login Successfully")) {
                    openHome();
                } else {
                    Toast.makeText(Login.this, response, Toast.LENGTH_LONG).show();
                }
            }
        },
            new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){
                    Toast.makeText(Login.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                    Map<String, String> map = new HashMap<String, String>();
                    map.put(KEY_USERNAME, username);
                    map.put(KEY_PASSWORD, password);
                    return map;
                }

            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }
    private void openHome(){
        Intent intent = new Intent(this, Home.class);
        intent.putExtra(KEY_USERNAME, username);
        startActivityForResult(intent, 100);

    }
    @Override
    public void onClick(View v) {
        if (v == bLogin) {
            userLogin();
            ClearEditTextAfterDoneTask();
        } else if (v == tvRegisterLink) {

            Intent intent = new Intent(Login.this, Register.class);
            startActivity(intent);
        }else if (v == tvForgotPasswordLink){
            Intent intent = new Intent (Login.this, Forgot.class);
            startActivity(intent);
        }
    }
    public void ClearEditTextAfterDoneTask() {

        etUsername.getText().clear();
        etPassword.getText().clear();
    }
}




