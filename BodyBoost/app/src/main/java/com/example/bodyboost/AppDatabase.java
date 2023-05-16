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
                            // Exercise set - 0
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (0, 1 , 10 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (0, 2 , 20 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (0, 3 , 0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (0, 5 , 0 , '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (0, 11 , 0  , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (0, 12 , 0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (0, 13 , 0 , '30 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (0, 28 , 15 , null)");

                            // Exercise set - 1
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (1, 4 , 0 , '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (1, 20 , 0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (1, 23 , 0 , ' 45 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (1, 31 , 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (1, 32 , 12  , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (1, 33 , 10 , null)");

                            // Exercise set - 2
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 1 , 10 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 3 , 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 5 , 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 11 , 14 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 12 , 14  , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 13 ,  14, null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 26 , 12 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 27 , 10 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 28 , 8  , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 29 , 8 , null)");

                            // Exercise set - 3
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (3, 6 , 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (3, 7 , 0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (3, 8 , 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (3, 9 , 12 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (3, 10 , 10  , null)");

                            // Exercise set - 4
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (4, 4 , 0 , '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (4, 20 , 0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (4, 23, 0 , ' 45 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (4, 34 , 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (4, 35 , 15  , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (4, 36 , 12 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (4, 37 , 10  , null)");


                        }
                    })
                    .build();
        }
        return INSTANCE;
    }

}

