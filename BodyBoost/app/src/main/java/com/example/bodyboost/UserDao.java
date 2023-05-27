package com.example.bodyboost;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT COUNT(userId) FROM User WHERE username = :username AND password = :password")
    int correspondingUsers(String username, String password);

    @Query("SELECT userId FROM User WHERE username = :username")
    int getUserId(String username);

}
