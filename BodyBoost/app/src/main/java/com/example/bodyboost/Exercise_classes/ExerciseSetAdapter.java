package com.example.bodyboost.Exercise_classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodyboost.Exercise;
import com.example.bodyboost.R;

import java.util.List;

public class ExerciseSetAdapter extends RecyclerView.Adapter<ExerciseSetAdapter.MyViewHolder>{
    private List<ExerciseSet> exerciseSetList;
    private List<Exercise> exerciseList;

    public ExerciseSetAdapter(List<ExerciseSet> exerciseSetList, List<Exercise> exerciseList){
        this.exerciseSetList = exerciseSetList;
        this.exerciseList = exerciseList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView timeRepetitionsTextView;
        private TextView exerciseNameTextView;

        public MyViewHolder(final View view){
            super(view);
            exerciseNameTextView = view.findViewById(R.id.exerciseName);
            timeRepetitionsTextView = view.findViewById(R.id.timeRepetitionsTextView);
        }
    }

    @NonNull
    @Override
    public ExerciseSetAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_exercises, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseSetAdapter.MyViewHolder holder, int position) {
        ExerciseSet exerciseSet = this.exerciseSetList.get(position);
        Exercise exercise = this.exerciseList.get(position);


        holder.exerciseNameTextView.setText(exercise.getExerciseName());

        if(exerciseSet.getRepetitions() == 0){
            holder.timeRepetitionsTextView.setText(exerciseSet.getTime());
        }
        else{
            holder.timeRepetitionsTextView.setText(Integer.toString(exerciseSet.getRepetitions()));
        }

    }

    @Override
    public int getItemCount() {
        return exerciseSetList.size();
    }

}