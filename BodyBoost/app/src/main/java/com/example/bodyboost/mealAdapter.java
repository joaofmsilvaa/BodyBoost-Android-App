package com.example.bodyboost;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class mealAdapter extends RecyclerView.Adapter<mealAdapter.MyViewHolder>{
    private ArrayList<Meal> mealList;

    public mealAdapter(ArrayList<Meal> mealList){
        this.mealList = mealList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView mealNameText;

        public MyViewHolder(final View view){
            super(view);
            mealNameText = view.findViewById(R.id.exerciseName);
        }
    }

    @NonNull
    @Override
    public mealAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_meals, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull mealAdapter.MyViewHolder holder, int position) {
        String name = mealList.get(position).getmealName();
        holder.mealNameText.setText(name);
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

}
