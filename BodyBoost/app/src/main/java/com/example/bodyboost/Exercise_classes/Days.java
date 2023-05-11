package com.example.bodyboost.Exercise_classes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Days {

    @PrimaryKey(autoGenerate = true)
    private int day_id;
    private String day;
    private int number_exercises;

    public Days(int day_id,String day, int number_exercises) {
        this.day_id = day_id;
        this.day = day;
        this.number_exercises = number_exercises;
    }

    public int getDay_id() {
        return day_id;
    }
    public String getDay() {
        return day;
    }

    public int getNumber_exercises() {
        return number_exercises;
    }

}

