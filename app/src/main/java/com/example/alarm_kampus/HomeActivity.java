package com.example.alarm_kampus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.alarm_kampus.RecycleHari.RecycleAdapter;

public class HomeActivity extends AppCompatActivity {

    Context context;
    RecyclerView rv;
    RecyclerView.Adapter recycleViewAdapter;
    RecyclerView.LayoutManager recycleViewLayout;

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

    }
}