package com.example.alarm_kampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

    EditText username, password;
    EditText stb = findViewById(R.id.stambuk);
    EditText psw = findViewById(R.id.password);
    Button btnLogin = findViewById(R.id.btnLogin);

    ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stb.getText().toString().length() == 0 || psw.getText().toString().length() == 0)
                {
                    Toast.makeText(loginActivity.this, "Mohon periksa kembali inputan anda", Toast.LENGTH_LONG).show();
                }
                else {
                    String s = stb.getText().toString();
                    String p = psw.getText().toString();

                    apiInterface = ApiClient.getClient().create(ApiInterface.class);

                    Call<Login> loginCall = apiInterface.loginResponse(s,p);
                    loginCall.enqueue(new Callback<Login>() {
                        @Override
                        public void onResponse(Call<Login> call, Response<Login> response) {
                            if (response.body() != null && response.isSuccessful() && response.body().isStatus())
                            {
                                Toast.makeText(loginActivity.this, response.body().getLoginData().getNmmhs(), Toast.LENGTH_LONG).show();
                                startActivity(new Intent(loginActivity.this, HomeActivity.class));
                                finish();
                            }
                            else
                            {
                                Toast.makeText(loginActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Login> call, Throwable t) {
                            Toast.makeText(loginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        }
                    });


                }

            }
        });




    }
}