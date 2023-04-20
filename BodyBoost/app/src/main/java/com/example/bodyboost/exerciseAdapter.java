package com.example.bodyboost;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class exerciseAdapter extends RecyclerView.Adapter<exerciseAdapter.MyViewHolder>{
    private ArrayList<Exercise> exerciseList;

    public exerciseAdapter(ArrayList<Exercise> exerciseList){
        this.exerciseList = exerciseList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView exerciseNameText;

        public MyViewHolder(final View view){
            super(view);
            exerciseNameText = view.findViewById(R.id.exerciseName);
        }
    }

    @NonNull
    @Override
    public exerciseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_exercises, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull exerciseAdapter.MyViewHolder holder, int position) {
        String name = exerciseList.get(position).getExerciseName();
        holder.exerciseNameText.setText(name);
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

}
