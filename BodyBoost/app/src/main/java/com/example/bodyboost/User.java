package com.example.bodyboost;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    int userId;

    String username;
    String password;
    float weight;
    float height;
    String objective;

    public User(int userId, String username, String password, float weight, float height, String objective) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.weight = weight;
        this.height = height;
        this.objective = objective;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }
    public String getObjective() {
        return objective;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }
}
