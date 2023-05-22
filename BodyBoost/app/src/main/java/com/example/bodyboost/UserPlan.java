package com.example.bodyboost;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.bodyboost.Exercise_classes.ExerciseSet;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = User.class,
                parentColumns = "userId",
                childColumns = "userId"
        ),
        @ForeignKey(
                entity = WorkoutPlan.class,
                parentColumns = "planId",
                childColumns = "planId"
        )
})
public class UserPlan {

    @PrimaryKey
    int user_planId;

    int userId;
    int planId;

    public UserPlan(int user_planId, int userId, int planId) {
        this.user_planId = user_planId;
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