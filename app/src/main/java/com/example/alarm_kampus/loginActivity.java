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
    ApiInterface apiInterface;
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

//                    apiInterface = ApiClient.getClient().create(ApiInterface.class);
                    Log.e("apiInterface : " + apiInterface, "tesss");

                    Call<Login> loginCall = apiInterface.loginResponse(Username,Password, "071994");
                    Log.e("login : " + Username + Password, "tesss");

                    loginCall.enqueue(new Callback<Login>() {
                        @Override
                        public void onResponse(Call<Login> call, Response<Login> response) {
                            Log.e("login : " + response, "tesss");

                            if (response.body() != null && response.isSuccessful() && response.body().isStatus())
                            {
                                Toast.makeText(loginActivity.this, response.body().getLoginData().getNmmhs(), Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(loginActivity.this, HomeActivity.class);
                                startActivity(intent);
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