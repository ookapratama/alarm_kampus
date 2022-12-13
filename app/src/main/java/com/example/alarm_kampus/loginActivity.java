package com.example.alarm_kampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    EditText username, password;
//    String url = "https://service.undipa.ac.id/mhs.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText stb = findViewById(R.id.stambuk);
        EditText psw = findViewById(R.id.password);
        Button btnLogin = findViewById(R.id.btnLogin);

        apiIn

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stb.getText().toString().length() == 0 || psw.getText().toString().length() == 0)
                {
                    Toast.makeText(loginActivity.this, "Mohon periksa kembali inputan anda", Toast.LENGTH_LONG).show();
                }
                else {

                    apiClient = ApiClient.

                    startActivity(new Intent(loginActivity.this, HomeActivity.class));
                    finish();
                }

            }
        });




    }
}