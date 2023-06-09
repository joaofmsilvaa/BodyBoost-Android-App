package com.example.bodyboost.nutricion;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bodyboost.AppDatabase;
import com.example.bodyboost.Feed_classes.FeedDao;
import com.example.bodyboost.R;

public class RecipeFragment extends Fragment{

    private AppDatabase db;
    private MealIngredientsDao mealIngredientsDao;
    private MealsDao mealsDao;

    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.context = this.getContext();

        // Obtain an instance of AppDatabase and DaysDao
        db = AppDatabase.getInstance(getContext());
        mealIngredientsDao = db.getMealIngredientsDao();
        mealsDao = db.getMealsDao();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Stores the given argument ( an ID of the selected new ) in the newsId variable
        int mealsId = com.example.bodyboost.nutricion.nutricionFragmentArgs.fromBundle(getArguments()).getSelectedRecipe();

        ImageView mealImageView = view.findViewById(R.id.mealImageView2);
        TextView recipeName = view.findViewById(R.id.recipeName2);

        Glide.with(context).load(mealsDao.getMealsImgById(mealsId)).into(mealImageView);
        recipeName.setText(mealsDao.getMealsNameById(mealsId));

    }

}