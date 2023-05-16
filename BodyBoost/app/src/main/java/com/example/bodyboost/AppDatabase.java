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
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Push-up chair dips', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Wall push-ups', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Jump rope', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Knee push-ups', 'Lose weight')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Squat', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Side Jump', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Deep crunch', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Side leg raises', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Donkey kicks', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('One-arm push-ups', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Wide-arm push-ups', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Diamond push-ups', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Abdominal crunch', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Mountain climbers', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Heel touchh', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Russian twist', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Leg raises', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Jumping jacks', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Burpees', 'Lose weight')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Skipping', 'Lose weight')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Air bicycle', 'Lose weight')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Plank', 'Lose weight')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('V-sit crunch', 'Lose weight')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Extended-arm crunch', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Barbell bench press', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Pull-ups', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Straight Supine with Bar', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Chest in parallel', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Crucifix on the fly', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Push-ups on the wall', 'Gain Weigh')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Front raise with dumbbells', 'Lose weight')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Fixed barbell lifts', 'Lose weight')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Closed barbell pulldown', 'Lose weight')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Isometric squat', 'Lose weight')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Bulgarian squat', 'Lose weight')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Chair extensor', 'Lose weight')");
                            db.execSQL("INSERT INTO Exercise('exerciseName', 'exerciseType') Values ('Jumping jacks', 'Lose weight')");

                            // Exercise set

                            // Exercise set - Monday
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (0, 1 , 10 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (0, 2 , 20 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (0, 3 , 0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (0, 5 , 0 , '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (0, 11 , 0  , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (0, 12 , 0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (0, 13 , 0 , '30 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (0, 28 , 15 , null)");

                            // Exercise set - Tuesday
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (1, 4 , 0 , '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (1, 20 , 0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (1, 23 , 0 , '45 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (1, 26 , 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (1, 28 , 12  , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (1, 33 , 10 , null)");

                            // Exercise set - Wednesday
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 1 , 10 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 3 , 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 5 , 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 11 , 14 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 12 , 14  , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 26 , 12 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 27 , 10 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (2, 28 , 8  , null)");

                            // Exercise set - Thursday
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (3, 6 , 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (3, 7 , 0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (3, 8 , 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (3, 9 , 12 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (3, 10 , 10  , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (3, 13 ,  14, null)");


                            // Exercise set - Friday
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (4, 4 , 0 , '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (4, 20 , 0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (4, 23, 0 , '45 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (4, 34 , 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (4, 35 , 15  , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (4, 36 , 12 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (4, 37 , 10  , null)");

                            // Exercise set - Saturday
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (5, 14 , 10 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (5, 15 , 12 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (5, 16,  15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (5, 17 , 15 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (5, 18 , 15  , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (5, 24 , 12 , null)");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (5, 25 , 10  , null)");

                            // Exercise set - Sunday
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (6, 19,  0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (6, 20 , 0 , '2 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (6, 21 , 0  , '2 minutes')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (6, 22 , 0 , '1 minute')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (6, 23 , 0  , '45 seconds')");
                            db.execSQL("INSERT INTO ExerciseSet('exerciseSetID', 'exerciseId', 'repetitions', 'time') Values (6, 29 , 8 , null)");


                        }
                    })
                    .build();
        }
        return INSTANCE;
    }

}

