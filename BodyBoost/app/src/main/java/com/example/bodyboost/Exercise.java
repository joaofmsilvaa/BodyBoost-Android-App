package com.example.bodyboost;

public class Exercise {
    private String exerciseName;


    public Exercise(String exerciseName){
        this.exerciseName = exerciseName;
    }

    public String getExerciseName(){
        return(exerciseName);
    }

    public void setExerciseName(String exerciseName){
        this.exerciseName = exerciseName;
    }
}
