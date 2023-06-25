package com.example.bodyboost.Exercise_classes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bodyboost.AppDatabase;
import com.example.bodyboost.Exercise;
import com.example.bodyboost.ExerciseSteps;
import com.example.bodyboost.ExerciseStepsDao;
import com.example.bodyboost.HomeFragment;
import com.example.bodyboost.R;
import com.example.bodyboost.Report_classes.Report;
import com.example.bodyboost.UserCompleted;
import com.example.bodyboost.UserCompletedDao;

import org.w3c.dom.Text;

import java.util.List;

public class ExerciseSetAdapter extends RecyclerView.Adapter<ExerciseSetAdapter.MyViewHolder> {

    private int day;
    private List<Exercise> exerciseList;
    private Context context;
    private ExerciseSetAdapterEventListener eventListener;

    private int currentImg = 0;

    public ExerciseSetAdapter(ExerciseSetAdapterEventListener eventListener, int dayId ,List<Exercise> exerciseList, Context context) {
        this.eventListener = eventListener;
        this.day = dayId;
        this.exerciseList = exerciseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ExerciseSetAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_exercises, parent, false);
        return new MyViewHolder(itemView, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseSetAdapter.MyViewHolder holder, int position) {
        AppDatabase db = AppDatabase.getInstance(context);
        UserCompletedDao userCompletedDao = db.getUserCompletedDao();
        ExerciseSetDao exerciseSetDao = db.getExerciseSetDao();
        ExerciseStepsDao exerciseStepsDao = db.getExerciseStepsDao();

        Exercise exercise = exerciseList.get(position);

        ExerciseSet getExerciseInfos = exerciseSetDao.getInfosForExercise(exercise.getExerciseId());

        holder.exerciseNameTextView.setText(exercise.getExerciseName());
        holder.exerciseDescTextView.setText(exercise.getExerciseDescription());

        List<String> exerciseStepImages = exerciseStepsDao.getExerciseSteps(exercise.getExerciseId());

        Glide.with(holder.context).load(R.drawable.chairdips_1).into(holder.exerciseImageView);
        holder.button5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.left_arrow_disabled));

        int drawableResourceId = holder.context.getResources().getIdentifier(exerciseStepImages.get(0), "drawable", holder.context.getPackageName());

        Glide.with(holder.context).load(drawableResourceId).into(holder.exerciseImageView);


        if (getExerciseInfos.getRepetitions() == 0) {
            holder.timeRepetitionsTextView.setText(getExerciseInfos.getTime());
        } else {
            holder.timeRepetitionsTextView.setText(getExerciseInfos.getRepetitions() + "x");
        }

        if (holder.weightCard != null) {
            if (userCompletedDao.checkIfExerciseCompleted(HomeFragment.userId, day, exercise.getExerciseId()) == 1) {
                holder.weightCard.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.rounded_exercise_completed) );
                holder.exerciseDoneButton.setText("DONE");
            } else {
                holder.weightCard.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.rounded_exercise_uncompleted) );
                holder.exerciseDoneButton.setText("NOT DONE");
            }
        }

        holder.exerciseDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int test = userCompletedDao.checkIfExerciseCompleted(HomeFragment.userId, day, exercise.getExerciseId());

                if (test == 1) {

                    userCompletedDao.updateExerciseCompleted(0,day,HomeFragment.userId,exercise.getExerciseId());
                    eventListener.onExerciseCompleted();
                } else {

                    userCompletedDao.updateExerciseCompleted(1,day,HomeFragment.userId,exercise.getExerciseId());
                    eventListener.onExerciseCompleted();
                }
            }
        });

        if (exerciseStepImages.size() > 1) {
            if (exerciseStepImages.size() == 2) {
                holder.button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder.button5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.left_arrow));
                        holder.button4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.right_arrow_disabled));

                        int drawableResourceId = holder.context.getResources().getIdentifier(exerciseStepImages.get(1), "drawable", holder.context.getPackageName());

                        Glide.with(holder.context).load(drawableResourceId).into(holder.exerciseImageView);
                    }
                });

                holder.button5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder.button4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.right_arrow));
                        holder.button5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.left_arrow_disabled));

                        int drawableResourceId = holder.context.getResources().getIdentifier(exerciseStepImages.get(0), "drawable", holder.context.getPackageName());

                        Glide.with(holder.context).load(drawableResourceId).into(holder.exerciseImageView);
                    }
                });

            } else if (exerciseStepImages.size() == 3) {
                holder.button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (currentImg == 2) {
                            holder.button5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.left_arrow));
                            holder.button4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.right_arrow));
                        } else {
                            holder.button5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.left_arrow));
                            holder.button4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.right_arrow));
                            currentImg++;
                            int drawableResourceId = holder.context.getResources().getIdentifier(exerciseStepImages.get(currentImg), "drawable", holder.context.getPackageName());
                            Glide.with(holder.context).load(drawableResourceId).into(holder.exerciseImageView);
                        }
                    }
                });

                holder.button5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (currentImg == 0) {
                            holder.button4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.right_arrow));
                            holder.button5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.left_arrow));
                        } else if (currentImg == 1) {
                            holder.button5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.left_arrow_disabled));
                            holder.button4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.right_arrow));
                        } else {
                            holder.button5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.left_arrow_disabled));
                            holder.button4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.right_arrow));
                        }
                        currentImg--;
                        int drawableResourceId = holder.context.getResources().getIdentifier(exerciseStepImages.get(currentImg), "drawable", holder.context.getPackageName());
                        Glide.with(holder.context).load(drawableResourceId).into(holder.exerciseImageView);
                    }
                });
            }
        } else {
            holder.button4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.right_arrow_disabled));
            holder.button5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.left_arrow_disabled));
        }
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public void updateData(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private Context context;
        private TextView timeRepetitionsTextView;
        private TextView exerciseNameTextView;
        private TextView exerciseDescTextView;
        private ImageButton button4;
        private ImageButton button5;
        private ImageView exerciseImageView;
        private View weightCard;
        private Button exerciseDoneButton;

        public MyViewHolder(final View view, Context context) {
            super(view);
            this.context = context;
            exerciseNameTextView = view.findViewById(R.id.exerciseName);
            exerciseDescTextView = view.findViewById(R.id.exerciseDescTextView);
            timeRepetitionsTextView = view.findViewById(R.id.timeRepetitionsTextView);
            exerciseImageView = view.findViewById(R.id.exerciseImageView);
            weightCard = view.findViewById(R.id.weightCard);
            exerciseDoneButton = view.findViewById(R.id.exerciseDoneButton);
            button4 = view.findViewById(R.id.button4);
            button5 = view.findViewById(R.id.button5);
        }
    }

    public interface ExerciseSetAdapterEventListener {
        void onExerciseCompleted();
    }
}