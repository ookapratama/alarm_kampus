package com.example.alarm_kampus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alarm_kampus.RecycleHari.RecycleAdapter;

public class HomeActivity extends AppCompatActivity {

    Context context;
    RecyclerView rv;
    RecyclerView.Adapter recycleViewAdapter;
    RecyclerView.LayoutManager recycleViewLayout;
    ImageView imageView;
    TextView viewAlarm;

    Button detail_hari;

    String[] hari = {
            "Senin", "Selasa", "Rabu", "Kamis", "Jumat"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        context = getApplicationContext();
        rv = findViewById(R.id.recycleHari);
        recycleViewLayout = new LinearLayoutManager(context);
        rv.setLayoutManager(recycleViewLayout);
        recycleViewAdapter = new RecycleAdapter(context, hari);
        rv.setAdapter(recycleViewAdapter);

        imageView = findViewById(R.id.setting);
        viewAlarm = findViewById(R.id.viewAlarm);
        detail_hari = findViewById(R.id.detail_hari);

        detail_hari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, JadwalMatkul.class);
                startActivity(i);
            }
        });

        viewAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, AlarmAktif.class);
                startActivity(i);
                finish();
            }
        });

        rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, JadwalMatkul.class);
                startActivity(i);
                finish();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, Setting.class);
                startActivity(i);
                finish();
            }
        });

    }



}