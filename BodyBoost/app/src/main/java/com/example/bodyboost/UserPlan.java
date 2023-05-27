package com.example.bodyboost;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.bodyboost.Exercise_classes.ExerciseSet;


@Entity

public class UserPlan {

    @PrimaryKey(autoGenerate = true)
    int user_planId;

    int userId;
    int planId;

    public UserPlan(int userId, int planId) {
        this.userId = userId;
        this.planId = planId;
    }

    public int getUser_planId() {
        return user_planId;
    }

    public int getUserId() {
        return userId;
    }

    public int getPlanId() {
        return planId;
    }
}