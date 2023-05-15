package com.example.bodyboost;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Exercise {

    @PrimaryKey(autoGenerate = true)
    private int exerciseId;
    private String exerciseName;

    private String exerciseType;

    public Exercise(int exerciseId, String exerciseName, String exerciseType){
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.exerciseType = exerciseType;
    }

    public String getExerciseName(){
        return(exerciseName);
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public String getExerciseType() {
        return exerciseType;
    }
}
