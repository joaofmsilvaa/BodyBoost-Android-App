package com.example.bodyboost.models.databaseModels;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bodyboost.models.Exercise;
import com.example.bodyboost.models.UserCompleted;

import java.util.List;

@Dao
public interface UserCompletedDao {

    @Query("SELECT exercise.* " +
            "FROM exercise, usercompleted, workoutplan " +
            "WHERE userId = :userId AND usercompleted.dayId = :dayId AND exercise.exerciseId = usercompleted.exerciseId " +
            "AND workoutplan.exerciseId = exercise.exerciseId AND workoutplan.planId = :planId " +
            "AND workoutplan.dayId = userCompleted.dayId AND workoutplan.exerciseId = userCompleted.exerciseId")
    List<Exercise> getExercisesForUser(int userId, int dayId, int planId);

    @Query("SELECT count(userCompletedId) FROM exercise,UserCompleted WHERE userId = :userId AND dayId = :dayId AND exercise.exerciseId = UserCompleted.exerciseId")
    int countExercisesForUser(int userId, int dayId);

    @Query("SELECT COUNT(userId) FROM usercompleted WHERE userId = :userId AND dayId = :dayId")
    int ammountOfExercisesInDay(int userId, int dayId);


    @Query("SELECT COUNT(completed) FROM UserCompleted WHERE userId = :userId AND dayId = :dayId AND completed = 1")
    int ammountCompleted(int userId, int dayId);


    @Query("SELECT completed FROM UserCompleted WHERE userId = :userId AND dayId = :dayId AND exerciseId = :exerciseId")
    int checkIfExerciseCompleted(int userId, int dayId, int exerciseId);


    @Query("UPDATE usercompleted SET completed = :status WHERE usercompleted.dayId = :dayId AND userId = :userId AND exerciseId = :exerciseId")
    void updateExerciseCompleted(int status,int dayId, int userId, int exerciseId);

    @Insert
    void insert(UserCompleted userCompleted);

    @Query("DELETE FROM UserCompleted WHERE userId = :id")
    void deleteByUserId(int id);

}