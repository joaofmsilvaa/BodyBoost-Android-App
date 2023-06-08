package com.example.bodyboost;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.bodyboost.Exercise_classes.Days;
import com.example.bodyboost.Exercise_classes.DaysDao;
import com.example.bodyboost.Exercise_classes.ExerciseSet;
import com.example.bodyboost.Exercise_classes.ExerciseSetDao;
import com.example.bodyboost.Feed_classes.Feed;
import com.example.bodyboost.Feed_classes.FeedDao;
import com.example.bodyboost.Report_classes.Report;
import com.example.bodyboost.Report_classes.ReportDao;
import com.example.bodyboost.nutricion.Meals;
import com.example.bodyboost.nutricion.MealsDao;

@Database(entities = {Report.class, Days.class, Exercise.class, ExerciseSet.class, WorkoutPlan.class ,Feed.class, Meals.class ,User.class, UserPlan.class, UserCompleted.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ReportDao getReportDao();
    public abstract DaysDao getDaysDao();
    public abstract ExerciseSetDao getExerciseSetDao();
    public abstract  WorkoutPlanDao getWorkoutPlanDao();
    public abstract FeedDao getFeedDao();
    public abstract MealsDao getMealsDao();
    public abstract UserPlanDao getUserPlanDao();
    public abstract UserDao getUserDao();
    public abstract UserCompletedDao getUserCompletedDao();

    // Gets an instance of the app database
    private static AppDatabase INSTANCE;


    public static com.example.bodyboost.AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "AppDatabase").allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            // Days and exercises
                            db.execSQL("INSERT INTO Days (dayId, day) VALUES (0, 'Monday')");
                            db.execSQL("INSERT INTO Days (day) VALUES ('Tuesday')");
                            db.execSQL("INSERT INTO Days (day) VALUES ('Wednesday')");
                            db.execSQL("INSERT INTO Days (day) VALUES ('Thursday')");
                            db.execSQL("INSERT INTO Days (day) VALUES ('Friday')");
                            db.execSQL("INSERT INTO Days (day) VALUES ('Saturday')");
                            db.execSQL("INSERT INTO Days (day) VALUES ('Sunday')");

                            // Exercises
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Push-up chair dips')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Wall push-ups')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Jump rope')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Knee push-ups')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Squat')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Side Jump')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Deep crunch')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Side leg raises')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Donkey kicks')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('One-arm push-ups')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Wide-arm push-ups')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Diamond push-ups')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Abdominal crunch')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Mountain climbers')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Heel touch')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Russian twist')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Leg raises')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Jumping jacks')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Burpees')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Skipping')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Air bicycle')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Plank')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('V-sit crunch')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Extended-arm crunch')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Barbell bench press')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Pull-ups')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Straight Supine with Bar')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Chest in parallel')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Crucifix on the fly')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Push-ups on the wall')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Front raise with dumbbells')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Fixed barbell lifts')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Closed barbell pulldown')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Isometric squat')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Bulgarian squat')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Chair extensor')");
                            db.execSQL("INSERT INTO Exercise (exerciseName) VALUES ('Jumping jacks')");


                            // Exercise set

                            // Exercise set - Monday
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (0, 1, 1, 10, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (0, 2, 2, 20, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (0, 3, 3, 0, '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (0, 5, 4, 0, '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (0, 11, 5, 0, '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (0, 12, 6, 0, '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (0, 13, 7, 0, '30 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (0, 28, 8, 15, null)");

                            // Exercise set - Tuesday
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (1, 4, 1, 0, '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (1, 20, 2, 0, '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (1, 23, 3, 0, '45 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (1, 26, 4, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (1, 28, 5, 12, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (1, 33, 6, 10, null)");

                            // Exercise set - Wednesday
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (2, 1, 1, 10, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (2, 3, 2, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (2, 5, 3, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (2, 11, 4, 14, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (2, 12, 5, 14, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (2, 26, 6, 12, null)");
                            db.execSQL("INSERT INTO ExerciseSet('dayId', 'exerciseId', 'orderIndex','repetitions', 'time') Values (2, 28 , 8, 8  , null)");

                            // Exercise set - Thursday
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (3, 6, 1, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (3, 7, 2, 0, '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (3, 8, 3, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (3, 9, 4, 12, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (3, 10, 5, 10, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (3, 13, 6, 14, null)");

                            // Exercise set - Friday
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (4, 4, 1, 0, '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (4, 20, 2, 0, '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (4, 23, 3, 0, '45 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (4, 34, 4, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (4, 35, 5, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (4, 36, 6, 12, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (4, 37, 7, 10, null)");

                            // Exercise set - Saturday
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (5, 14, 1, 10, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (5, 15, 2, 12, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (5, 16, 3, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (5, 17, 4, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (5, 18, 5, 15, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (5, 24, 6, 12, null)");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (5, 25, 7, 10, null)");


                            // Exercise set - Sunday
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (6, 19, 1, 0, '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (6, 20, 2, 0, '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (6, 21, 3, 0, '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (6, 22, 4, 0, '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (6, 23, 5, 0, '45 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet(dayId, exerciseId, orderIndex, repetitions, time) VALUES (6, 29, 6, 8, null)");

                            // WORKOUT PLANS

                            // WORKOUT PLAN - 1

                            // Workout Plan - 1 - day 1
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 0, 1, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 0, 2, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 0, 3, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 0, 5, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 0, 11, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 0, 12, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 0, 13, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 0, 28, 'gain mass')");


                            // Workout Plan - 1 - day 2
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 1, 4, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 1, 20, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 1, 23, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 1, 26, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 1, 28, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 1, 33, 'gain mass')");

                            // Workout Plan - 1 - day 3
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 2, 1, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 2, 3, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 2, 5, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 2, 11, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 2, 12, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 2, 26, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 2, 27, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 2, 28, 'gain mass')");

                            // Workout Plan - 1 - day 4
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 3, 6, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 3, 7, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 3, 8, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 3, 9, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 3, 10, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 3, 13, 'gain mass')");


                            // Workout Plan - 1 - day 5
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 4, 4, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 4, 20, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 4, 23, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 4, 34, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 4, 35, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 4, 36, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 4, 37, 'gain mass')");

                            // Workout Plan - 1 - day 6
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 5, 14, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 5, 15, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 5, 16, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 5, 17, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 5, 18, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 5, 24, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (1, 5, 25, 'gain mass')");


                            // Workout Plan - 1 - day 7
                            db.execSQL("INSERT INTO WorkoutPlan('planId', 'dayId', 'exerciseId', 'type') Values (1, 6 , 19, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan('planId', 'dayId', 'exerciseId', 'type') Values (1, 6 , 20, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan('planId', 'dayId', 'exerciseId', 'type') Values (1, 6 , 21, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan('planId', 'dayId', 'exerciseId', 'type') Values (1, 6 , 22, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan('planId', 'dayId', 'exerciseId', 'type') Values (1, 6 , 23, 'gain mass')");
                            db.execSQL("INSERT INTO WorkoutPlan('planId', 'dayId', 'exerciseId', 'type') Values (1, 6 , 29, 'gain mass')");


                            // WORKOUT PLAN - 2
                            // Workout Plan - 2 - day 1
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 0, 36, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 0, 23, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 0, 4, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 0, 21, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 0, 11, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 0, 16, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 0, 7, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 0, 6, 'lose weight')");


                            // Workout Plan - 2 - day 2
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 1, 5, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 1, 16, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 1, 18, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 1, 29, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 1, 28, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 1, 33, 'lose weight')");


                            // Workout Plan - 2 - day 3
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 2, 10, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 2, 30, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 2, 15, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 2, 24, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 2, 21, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 2, 25, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 2, 27, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 2, 28, 'lose weight')");

                            // Workout Plan - 2 - day 4
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 3, 33, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 3, 31, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 3, 6, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 3, 9, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 3, 21, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 3, 13, 'lose weight')");

                            // Workout Plan - 2 - day 5
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 4, 18, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 4, 8, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 4, 3, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 4, 9, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 4, 23, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 4, 30, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 4, 37, 'lose weight')");

                            // Workout Plan - 2 - day 6
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 5, 31, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 5, 17, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 5, 14, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 5, 18, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 5, 21, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 5, 3, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 5, 8, 'lose weight')");

                            // Workout Plan - 2 - day 7
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 6, 26, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 6, 27, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 6, 17, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 6, 32, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 6, 5, 'lose weight')");
                            db.execSQL("INSERT INTO WorkoutPlan(planId, dayId, exerciseId, type) VALUES (2, 6, 24, 'lose weight')");

                            // Feed - News
                            db.execSQL("INSERT INTO Feed (newsTitle, newsSmallDescription, newsFullDescription, newsImg, newsDate) VALUES ('João Coelho abre época com boa marca em Yokohama', 'O velocista português João Coelho terminou no segundo lugar a corrida de 400 metros, com a marca de 45,46 segundos.', 'João Coelho, que é recordista de Portugal de 400 metros em pista coberta, ficou a 46 centésimos da qualificação direta para os Mundiais de Budapeste e a cinco centésimos do seu recorde pessoal.\n\nO atleta sportinguista aproveitou muito bem o ritmo do japonês Yuki Joseph Nakajima, vencedor em 45,31.\n\nCom este resultado, Coelho consegue pontos para subir no ranking mundial e abrir uma porta de qualificação para os Mundiais de Budapeste, no final de agosto.\nAinda em Yokohama, registo para a abertura de época do barreirista cubano Roger Iribarne, do Benfica, que terminou em quarto lugar com a marca de 13,37 segundos (vento: +0,8 m/s), numa prova dominada pelo japonês Shunsuke Izumiya, que fez a segunda melhor marca mundial do ano (13,07 segundos).', 'https://cdn-images.rtp.pt/icm/noticias/images/eb/eb80c6ff94c0c6fd4846fb61f6e10005?w=860&q=90&rect=0,48,1587,870&auto=format', '21/05/2023')");
                            db.execSQL("INSERT INTO Feed (newsTitle, newsSmallDescription, newsFullDescription, newsImg, newsDate) VALUES ('Jessica Inchude vence lançamento do peso em meeting na Polónia', 'A portuguesa Jessica Inchude venceu este domingo o lançamento do peso no meeting de Bialystok, na Polónia, com o seu melhor registo do ano, 18,65 metros.', 'A portuguesa Jessica Inchude venceu este domingo o lançamento do peso no meeting de Bialystok, na Polónia, com o seu melhor registo do ano, 18,65 metros, a dois centímetros do seu recorde pessoal.\n\nNa mesma prova, o segundo lugar também foi para uma lançadora lusa, Eliane Bandeira, com um arremesso a 18,20 metros, passando pela segunda vez na carreira os 18,00 metros. Inchude, que em Portugal apenas é superada pela recordista nacional, Auriol Dongmo, conseguiu ainda um registo de 18,63, em concurso de grande consistência, com cinco tiros a mais de 18 metros.\n\nNa qualificação para os Mundiais de Budapeste, ainda não atinge a marca de qualificação direta, que é de 18,80, mas reforça amplamente a sua posição no ranking de apuramento. Inchude é a primeira atleta sem marca de qualificação direta, em 17.ª, sendo que se vão apurar 36 lançadoras. Manterá a posição, mas com mais pontos.\n\nEliana Bandeira também está na lista de qualificação por ranking, neste momento na 26.ª posição.', 'https://cdn.record.pt/images/2023-05/img_920x518$2023_05_21_19_27_28_2131327.png', '22/05/2023')");

                            // Meals
                            db.execSQL("INSERT INTO Meals(mealName,mealsShortDescription,mealRecipe, mealImage) VALUES('Green tea noodles with sticky sweet chilli salmon', 'Green tea noodles bring a pop of colour to this easy midweek dinner.', 'Preheat oven to 220°C. Heat peanut oil in a small saucepan over low heat. Add ginger, long green shallot, lemongrass and a pinch of salt. Cook, stirring occasionally, for 6-8 minutes until long green shallot is very soft but not coloured. Remove from heat and cool.\n" +
                                    "Meanwhile, combine honey, olive oil and chilli paste in a bowl. Stir to combine. Line a baking tray with baking paper and add salmon. Rub honey mixture over salmon to coat, then season. Roast for 12-15 minutes for medium. Set aside, loosely covered with foil, to rest for 5 minutes.\n" +
                                    "Cook noodles according to packet instructions. Drain and rinse briefly with warm water.\n" +
                                    "Whisk lime juice, sugar, fish sauce and chilli flakes into the shallot oil mixture. Place noodles in a large bowl with three quarters of the shallot oil, season and toss to combine. Arrange on a serving platter and flake salmon over the top. Drizzle over remaining shallot oil and scatter with extra chilli flakes, toasted sesame seeds and shiso leaves. Serve at room temperature or chilled.', 'https://img.delicious.com.au/EEJ2ozkv/del/2020/10/green-tea-noodles-with-sticky-sweet-chilli-salmon-140868-2.jpg')");

                            // User - testUsers
                            db.execSQL("INSERT INTO User(userId, username, password, weight, height, objective) VALUES(0, 'user', 'password', 60.2, 1.60, 'gain muscle')");
                            db.execSQL("INSERT INTO User(username, password, weight, height, objective) VALUES('user2', 'password2', 60.2, 1.60, 'lose weight ')");

                            // UserPlan
                            db.execSQL("INSERT INTO UserPlan(userId,planId) VALUES(0, 1)");
                            db.execSQL("INSERT INTO UserPlan(userId,planId) VALUES(1, 2)");

                            // UserCompleteds

                            // Day 0
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 0, 1, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 0, 2, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 0, 3, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 0, 5, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 0, 11, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 0, 12, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 0, 13, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 0, 28, '0')");

                            // Day 1
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 1, 4, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 1, 20, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 1, 23, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 1, 26, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 1, 28, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 1, 33, '0')");

                            // Day 2
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 2, 1, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 2, 3, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 2, 5, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 2, 11, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 2, 12, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 2, 26, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 2, 27, '0')");

                            // Day 3
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 3, 6, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 3, 7, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 3, 8, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 3, 9, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 3, 10, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 3, 13, '0')");

                            // Day 4
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 4, 18, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 4, 8, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 4, 3, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 4, 9, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 4, 23, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 4, 30, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 4, 37, '0')");


                            // Day 5
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 5, 14, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 5, 15, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 5, 16, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 5, 17, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 5, 18, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 5, 24, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 5, 25, '0')");

                            // Day 6
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 6, 19, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 6, 20, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 6, 21, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 6, 22, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 6, 23, '0')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (0, 6, 29, '0')");


                            // USER2
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (1, 0, 1, 'true')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (1, 0, 2, 'true')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (1, 0, 3, 'true')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (1, 0, 5, 'true')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (1, 0, 11, 'true')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (1, 0, 12, 'true')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (1, 0, 13, 'true')");
                            db.execSQL("INSERT INTO UserCompleted(userId, dayId, exerciseId, completed) VALUES (1, 0, 28, 'false')");
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }

}

