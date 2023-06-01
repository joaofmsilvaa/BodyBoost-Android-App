package com.example.bodyboost.Exercise_classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodyboost.AppDatabase;
import com.example.bodyboost.Exercise;
import com.example.bodyboost.HomeFragment;
import com.example.bodyboost.R;
import com.example.bodyboost.UserCompletedDao;

import org.w3c.dom.Text;

import java.util.List;

public class ExerciseSetAdapter extends RecyclerView.Adapter<ExerciseSetAdapter.MyViewHolder>{
    private List<ExerciseSet> exerciseSetList;
    private List<Exercise> exerciseList;
    private Context context;
    private ExerciseSetAdapterEventListener eventListener;

    public ExerciseSetAdapter(ExerciseSetAdapterEventListener eventListener, List<ExerciseSet> exerciseSetList, List<Exercise> exerciseList){
        this.eventListener = eventListener;
        this.exerciseSetList = exerciseSetList;
        this.exerciseList = exerciseList;

    }

    @NonNull
    @Override
    public ExerciseSetAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_exercises, parent, false);

        return new MyViewHolder(itemView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseSetAdapter.MyViewHolder holder, int position) {
        AppDatabase db = AppDatabase.getInstance(context);
        UserCompletedDao userCompletedDao = db.getUserCompletedDao();

        ExerciseSet exerciseSet = this.exerciseSetList.get(position);
        Exercise exercise = this.exerciseList.get(position);

        // TO-DO fix the bug NULL POINTER EXCEPTION
        int exerciseID = exercise.getExerciseId();

        if(userCompletedDao.checkIfExerciseCompleted(HomeFragment.userId,HomeFragment.getCurrentDay(),exercise.getExerciseId())){
            holder.weightCard.setBackgroundResource(R.color.green);
        }
        else{
            holder.weightCard.setBackgroundResource(R.color.mainRed);
        }

        holder.exerciseDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userCompletedDao.checkIfExerciseCompleted(HomeFragment.userId, exerciseSet.dayId, exerciseSet.exerciseId)) {
                    userCompletedDao.updateCompleted(0, HomeFragment.userId, exerciseSet.dayId, exerciseSet.exerciseId);
                    eventListener.onExerciseCompleted();
                } else {
                    userCompletedDao.updateCompleted(1, HomeFragment.userId, exerciseSet.dayId, exerciseSet.exerciseId);
                    eventListener.onExerciseCompleted();
                }
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

    @Override
    public int getItemCount() {
        return exerciseSetList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private Context context;
        private TextView timeRepetitionsTextView;
        private TextView exerciseNameTextView;
        private TextView weightCard;
        private Button exerciseDoneButton;
        public MyViewHolder(final View view, Context context){
            super(view);
            this.context = context;
            exerciseNameTextView = view.findViewById(R.id.exerciseName);
            timeRepetitionsTextView = view.findViewById(R.id.timeRepetitionsTextView);
            weightCard = view.findViewById(R.id.weightCard);
            exerciseDoneButton = view.findViewById(R.id.exerciseDoneButton);
        }
    }


    public interface ExerciseSetAdapterEventListener {
        void onExerciseCompleted();
    }
}