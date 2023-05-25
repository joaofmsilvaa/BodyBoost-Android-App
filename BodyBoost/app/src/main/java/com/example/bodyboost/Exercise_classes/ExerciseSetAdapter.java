package com.example.bodyboost.Exercise_classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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

        private Context context;
        private TextView timeRepetitionsTextView;
        private TextView exerciseNameTextView;
        private CheckBox exerciseDoneCheckBox;
        public MyViewHolder(final View view, Context context){
            super(view);
            this.context = context;
            exerciseNameTextView = view.findViewById(R.id.exerciseName);
            timeRepetitionsTextView = view.findViewById(R.id.timeRepetitionsTextView);
            exerciseDoneCheckBox = view.findViewById(R.id.exerciseDoneCheckBox);
        }
    }

    @NonNull
    @Override
    public ExerciseSetAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_exercises, parent, false);

        return new MyViewHolder(itemView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseSetAdapter.MyViewHolder holder, int position) {
        ExerciseSet exerciseSet = this.exerciseSetList.get(position);
        Exercise exercise = this.exerciseList.get(position);

        holder.exerciseDoneCheckBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int dayId = exerciseSet.dayId;
                int exerciseId = exerciseSet.exerciseId;


            }
        });

        holder.exerciseNameTextView.setText(exercise.getExerciseName());

        if(exerciseSet.getRepetitions() == 0){
            holder.timeRepetitionsTextView.setText(exerciseSet.getTime());
        }
        else{
            holder.timeRepetitionsTextView.setText(Integer.toString(exerciseSet.getRepetitions()));
        }


    }

    public void updateData(List<ExerciseSet> exerciseSetList) {
        this.exerciseSetList = exerciseSetList;
    }

    @Override
    public int getItemCount() {
        return exerciseSetList.size();
    }


    public interface ExerciseSetAdapterEventListener {
        void onExerciseCompleted(int chatId, int exerciseId, Context context);
    }
}