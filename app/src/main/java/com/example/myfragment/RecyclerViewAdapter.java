package com.example.myfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private final List<Account> accountList;
    public RecyclerViewAdapter(List<Account> accountList) {
        this.accountList = accountList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_item_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Account account = accountList.get(position);

        holder.textViewNama.setText(account.getNama());
        holder.textViewEmail.setText(account.getEmail());
        holder.textViewPassword.setText(account.getPassword());
    }

    @Override
    public int getItemCount() {
        return accountList.size();
    }
}
