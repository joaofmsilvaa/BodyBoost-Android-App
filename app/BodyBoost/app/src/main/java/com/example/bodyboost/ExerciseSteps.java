package com.example.bodyboost;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ExerciseSteps {

    @PrimaryKey(autoGenerate = true)
    int exerciseStepsId;

    int exerciseId;

    String image;

    public ExerciseSteps(int exerciseStepsId, int exerciseId, String image) {
        this.exerciseStepsId = exerciseStepsId;
        this.exerciseId = exerciseId;
        this.image = image;
    }

    public int getExerciseStepsId() {
        return exerciseStepsId;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public String getImage() {
        return image;
    }
}
