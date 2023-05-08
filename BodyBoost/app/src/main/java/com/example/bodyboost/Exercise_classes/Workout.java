package com.example.bodyboost.Exercise_classes;

public class Workout {
    private String exerciseName;


    public Workout(String exerciseName){
        this.exerciseName = exerciseName;
    }

    public String getExerciseName(){
        return(exerciseName);
    }

    public void setExerciseName(String exerciseName){
        this.exerciseName = exerciseName;
    }
}
