package com.example.bodyboost;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Exercise {

    @PrimaryKey(autoGenerate = true)
    private int exerciseId;
    private String exerciseName;

    public Exercise(int exerciseId, String exerciseName){
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
    }

    public String getExerciseName(){
        return(exerciseName);
    }

    public int getExerciseId() {
        return exerciseId;
    }

}
