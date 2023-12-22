package com.example.myfragment;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewNama;
    public TextView textViewEmail;
    public TextView textViewPassword;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewNama = itemView.findViewById(R.id.textViewNama);
        textViewEmail = itemView.findViewById(R.id.textViewEmail);
        textViewPassword = itemView.findViewById(R.id.textViewPassword);
    }
}
