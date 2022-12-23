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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class loginActivity extends AppCompatActivity {


    String Username, Password;
    EditText stb, psw;
    Button btnLogin;
    ApiInterface apiInterface;
    SessionManager sessionManager;

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

                  userLogin(Username, Password);

                }

            }
        });

    }

    private void userLogin(String username, String password) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Login> loginCall = apiInterface.loginResponse(username,password, "071994");

        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){

                    //Ini untuk pindah
                    Toast.makeText(loginActivity.this, response.body().getLoginData().getNmmhs(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(loginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(loginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {

            }
        });

        Intent i = new Intent(this, HomeActivity.class);
        finish();
        startActivity(i);
    }
}