package com.example.bodyboost.Exercise_classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodyboost.Exercise;
import com.example.bodyboost.R;

import java.util.ArrayList;
import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.MyViewHolder>{
    private List<Exercise> exerciseList;

    public ExerciseAdapter(List<Exercise> exerciseList){
        this.exerciseList = exerciseList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView exerciseNameText;

        public MyViewHolder(final View view){
            super(view);
            exerciseNameText = view.findViewById(R.id.weightValue);
        }
    }

    @NonNull
    @Override
    public ExerciseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_exercises, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseAdapter.MyViewHolder holder, int position) {
        Exercise exercises = this.exerciseList.get(position);

        holder.exerciseNameText.setText(exercises.getExerciseName());

    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

}
