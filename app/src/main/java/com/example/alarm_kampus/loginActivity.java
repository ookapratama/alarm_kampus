package com.example.alarm_kampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alarm_kampus.api.ApiInterface;
import com.example.alarm_kampus.api.ApiClient;
import com.example.alarm_kampus.model.login.Login;


public class loginActivity extends AppCompatActivity {


    String Username, Password;
    EditText stb, psw;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        stb = findViewById(R.id.stambuk);
        psw = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Username = stb.getText().toString();
                Password = psw.getText().toString();

                if (Username.length() == 0 || Password.length() == 0)
                {
                    Toast.makeText(loginActivity.this, "Mohon periksa kembali inputan anda", Toast.LENGTH_LONG).show();
                }
                else {

//

                }

            }
        });




    }
}