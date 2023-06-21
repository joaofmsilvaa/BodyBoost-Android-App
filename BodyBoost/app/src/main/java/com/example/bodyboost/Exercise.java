package com.example.bodyboost;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Exercise {

    @PrimaryKey(autoGenerate = true)
    private int exerciseId;
    private String exerciseName;

    private String exerciseDescription;

    public Exercise(int exerciseId, String exerciseName, String exerciseDescription ){
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
    }

    public String getExerciseName(){
        return(exerciseName);
    }

    public String getExerciseDescription(){
        return exerciseDescription;
    }
    public int getExerciseId() {
        return exerciseId;
    }

}
