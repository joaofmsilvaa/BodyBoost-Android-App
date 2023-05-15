package com.example.bodyboost;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.bodyboost.Exercise_classes.Days;
import com.example.bodyboost.Exercise_classes.DaysDao;
import com.example.bodyboost.Exercise_classes.ExerciseDao;
import com.example.bodyboost.Exercise_classes.ExerciseSet;
import com.example.bodyboost.Exercise_classes.ExerciseSetDao;
import com.example.bodyboost.Report_classes.Report;
import com.example.bodyboost.Report_classes.ReportDao;

@Database(entities = {Report.class, Days.class, Exercise.class, ExerciseSet.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ReportDao getReportDao();
    public abstract DaysDao getDaysDao();
    public abstract ExerciseDao getExerciseDao();
    public abstract ExerciseSetDao getExerciseSetDao();

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
                            db.execSQL("INSERT INTO Days ('day', 'numberOfExercises', 'concludedExercises') Values ('Monday', 10, 0)");
                            db.execSQL("INSERT INTO Days ('day', 'numberOfExercises', 'concludedExercises') Values ('Tuesday', 10, 0)");
                            db.execSQL("INSERT INTO Days ('day', 'numberOfExercises', 'concludedExercises') Values ('Wednesday', 10, 0)");
                            db.execSQL("INSERT INTO Days ('day', 'numberOfExercises', 'concludedExercises') Values ('Thursday', 10, 0)");
                            db.execSQL("INSERT INTO Days ('day', 'numberOfExercises', 'concludedExercises') Values ('Friday', 10, 0)");
                            db.execSQL("INSERT INTO Days ('day', 'numberOfExercises', 'concludedExercises') Values ('Saturday', 10, 0)");
                            db.execSQL("INSERT INTO Days ('day', 'numberOfExercises', 'concludedExercises') Values ('Sunday', 10, 0)");

                            // Exercises
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Push-up chair dips', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Wall push-ups', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Jump rope', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Knee push-ups', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Squat', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Side Jump', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Deep crunch', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Side leg raises', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Donkey kicks', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('One-arm push-ups', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Wide-arm push-ups', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Diamond push-ups', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Abdominal crunch', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Mountain climbers', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Heel touchh', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Russian twist', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Leg raises', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Jumping jacks', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Burpees', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Skipping', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Air bicycle', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Plank', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('V-sit crunch', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Extended-arm crunch', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Barbell bench press', 'massa')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Pull-ups', 'massa')");

                            // Exercise set
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (0, 'massa')");

                        }
                    })
                    .build();
        }
        return INSTANCE;
    }

}

