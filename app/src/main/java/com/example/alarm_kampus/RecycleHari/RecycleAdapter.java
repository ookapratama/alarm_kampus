package com.example.alarm_kampus.RecycleHari;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alarm_kampus.HomeActivity;
import com.example.alarm_kampus.JadwalMatkul;
import com.example.alarm_kampus.R;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private String[] hari;
    private Context context;

    public RecycleAdapter(Context context, String[] hari) {
        this.hari = hari;
        this.context = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.list_hari);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hari, parent, false);
//        view.setOnClickListener();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(hari[position]);
//        holder.textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(HomeActivity.class, JadwalMatkul.class);
//                startActivity(i);
//                finish();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return hari.length;
    }

}
