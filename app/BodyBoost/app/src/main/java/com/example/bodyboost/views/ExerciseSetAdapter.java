package com.example.bodyboost.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bodyboost.models.Exercise;
import com.example.bodyboost.models.ExerciseSet;
import com.example.bodyboost.R;
import com.example.bodyboost.viewmodels.ExerciseSetViewModel;
import com.example.bodyboost.viewmodels.ExerciseStepsViewModel;
import com.example.bodyboost.viewmodels.UserCompletedViewModel;

import java.util.List;

public class ExerciseSetAdapter extends RecyclerView.Adapter<ExerciseSetAdapter.MyViewHolder> {

    private int day;
    private List<Exercise> exerciseList;
    private Context context;
    private ExerciseSetAdapterEventListener eventListener;
    private UserCompletedViewModel userCompletedViewModel;
    private ExerciseSetViewModel exerciseSetViewModel;
    private ExerciseStepsViewModel exerciseStepsViewModel;

    // Variable to track the currently displayed image
    private int currentImg = 0;

    public ExerciseSetAdapter(ExerciseSetAdapterEventListener eventListener, int dayId ,List<Exercise> exerciseList, Context context) {
        // Initializing the needed viewmodels
        userCompletedViewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(UserCompletedViewModel.class);
        exerciseSetViewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(ExerciseSetViewModel.class);
        userCompletedViewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(UserCompletedViewModel.class);
        exerciseStepsViewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(ExerciseStepsViewModel.class);

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
        // Get current exercise
        Exercise exercise = exerciseList.get(position);

        // Get the information's of the current exercise such as the reps or time
        ExerciseSet getExerciseInfos = exerciseSetViewModel.getInfosForExercise(exercise.getExerciseId());

        // Set the name and description of the exercise
        holder.exerciseNameTextView.setText(exercise.getExerciseName());
        holder.exerciseDescTextView.setText(exercise.getExerciseDescription());

        // Get the exercise step images
        List<String> exerciseStepImages = exerciseStepsViewModel.getExerciseSteps(exercise.getExerciseId());

        holder.button5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.left_arrow_disabled));

        // Loading the first exercise step image
        int drawableResourceId = holder.context.getResources().getIdentifier(exerciseStepImages.get(0), "drawable", holder.context.getPackageName());
        Glide.with(holder.context).load(drawableResourceId).into(holder.exerciseImageView);

        // Handling the repetitions or time of the exercise
        if (getExerciseInfos.getRepetitions() == 0) {
            holder.timeRepetitionsTextView.setText(getExerciseInfos.getTime());
        } else {
            holder.timeRepetitionsTextView.setText(getExerciseInfos.getRepetitions() + "x");
        }

        // Updating the background of the weight card based on completion status
        if (holder.weightCard != null) {
            if (userCompletedViewModel.checkIfExerciseCompleted(HomeFragment.userId, day, exercise.getExerciseId()) == 1) {
                holder.weightCard.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.rounded_exercise_completed) );
            } else {
                holder.weightCard.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.rounded_exercise_uncompleted) );
            }
        }

        // Handling the click event for marking an exercise as completed or not
        holder.exerciseDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int exerciseCompletedCheck = userCompletedViewModel.checkIfExerciseCompleted(HomeFragment.userId, day, exercise.getExerciseId());

                if (exerciseCompletedCheck == 1) {

                    userCompletedViewModel.updateExerciseCompleted(0,day,HomeFragment.userId,exercise.getExerciseId());
                    eventListener.onExerciseCompleted();
                } else {

                    userCompletedViewModel.updateExerciseCompleted(1,day,HomeFragment.userId,exercise.getExerciseId());
                    eventListener.onExerciseCompleted();
                }
            }
        });

        // Handling the exercise steps image "swipe"
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