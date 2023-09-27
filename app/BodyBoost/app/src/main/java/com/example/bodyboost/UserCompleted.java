package com.example.bodyboost;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserCompleted {

    @PrimaryKey(autoGenerate = true)
    int userCompletedId;

    int userId;
    int dayId;
    int exerciseId;
    Boolean completed;

    public UserCompleted(int userCompletedId, int userId, int dayId, int exerciseId, Boolean completed) {
        this.userCompletedId = userCompletedId;
        this.userId = userId;
        this.dayId = dayId;
        this.exerciseId = exerciseId;
        this.completed = completed;
    }

    public int getUserCompletedId() {
        return userCompletedId;
    }

    public int getUserId() {
        return userId;
    }

    public int getDayId() {
        return dayId;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public Boolean getCompleted() {
        return completed;
    }
}
