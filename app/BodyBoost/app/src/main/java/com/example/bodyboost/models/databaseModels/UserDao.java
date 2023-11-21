package com.example.bodyboost.models.databaseModels;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bodyboost.models.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT COUNT(userId) FROM User WHERE username = :username")
    int isUsernameAvailable(String username);

    @Query("SELECT userId FROM User WHERE username = :username")
    int getUserId(String username);

    @Query("SELECT password FROM User WHERE userId = :id")
    String getPasswordById(int id);

    @Query("SELECT * FROM User WHERE userId = :id")
    User getUserById(int id);

    @Query("SELECT * FROM User WHERE username = :username")
    User getUserByName(String username);

    @Insert
    void insert(User user);

    @Update
    void updateUser(User user);
}
