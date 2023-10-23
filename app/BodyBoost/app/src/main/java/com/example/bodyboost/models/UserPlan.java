package com.example.bodyboost.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity

public class UserPlan {

    @PrimaryKey(autoGenerate = true)
    public int user_planId;
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