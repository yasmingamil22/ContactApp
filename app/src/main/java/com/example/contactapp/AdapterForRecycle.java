package com.example.contactapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterForRecycle extends  RecyclerView.Adapter<AdapterForRecycle.NewViewHolder> {
ArrayList<UserData > arrayList;

    public AdapterForRecycle(ArrayList<UserData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item,parent,false);
        return new NewViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {
        UserData view=arrayList.get(position);
        holder.tv_name.setText(arrayList.get(position).getName());
        holder.tv_number.setText(arrayList.get(position).getNumber());
        holder.tv_kind.setText(arrayList.get(position).getKind());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class NewViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_number;
        TextView tv_kind;

        public NewViewHolder(final View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_number = (TextView) itemView.findViewById(R.id.tv_number);
            tv_kind = (TextView) itemView.findViewById(R.id.tv_kind);
        }
    }
}
