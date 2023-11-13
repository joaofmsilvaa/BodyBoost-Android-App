package com.example.bodyboost.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    public int userId;

    public String username;

    @SerializedName("password")
    @Expose
    String password;

    @SerializedName("weight")
    @Expose
    float weight;

    @SerializedName("height")
    @Expose
    float height;

    @SerializedName("objective")
    @Expose
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

    public String getappUsername() {
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

    public void setappUsername(String appUsername) {
        this.username = appUsername;
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
