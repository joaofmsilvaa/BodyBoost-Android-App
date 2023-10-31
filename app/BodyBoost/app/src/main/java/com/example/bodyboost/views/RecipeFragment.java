package com.example.bodyboost.views;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bodyboost.models.databaseModels.AppDatabase;
import com.example.bodyboost.models.Ingredients;
import com.example.bodyboost.models.databaseModels.IngredientsDao;
import com.example.bodyboost.models.databaseModels.MealsDao;
import com.example.bodyboost.R;

import java.util.List;

public class RecipeFragment extends Fragment{

    private AppDatabase db;
    private MealsDao mealsDao;
    private IngredientAdapter adapter;
    private IngredientsDao ingredientsDao;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.context = this.getContext();

        // Obtain an instance of AppDatabase and DaysDao
        db = AppDatabase.getInstance(getContext());
        mealsDao = db.getMealsDao();
        ingredientsDao = db.getIngredientsDao();
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
        int mealsId = com.example.bodyboost.views.RecipeFragmentArgs.fromBundle(getArguments()).getSelectedRecipe();

        ImageView mealImageView = view.findViewById(R.id.mealImageView2);
        TextView recipeName = view.findViewById(R.id.recipeName2);
        TextView fullRecipe = view.findViewById(R.id.recipeTextView);
        TextView caloriesTextView = view.findViewById(R.id.caloriesTextView2);

        Glide.with(context).load(mealsDao.getMealsImgById(mealsId)).into(mealImageView);
        recipeName.setText(mealsDao.getMealsNameById(mealsId));
        fullRecipe.setText(mealsDao.getRecipeById(mealsId));
        caloriesTextView.setText(mealsDao.getCaloriesById(mealsId) + " cal");


        RecyclerView recyclerView = view.findViewById(R.id.ingredientsRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        List<Ingredients> allIngredientsInMeal = ingredientsDao.getIngredientsById(mealsId);
        adapter = new IngredientAdapter(allIngredientsInMeal);

        recyclerView.setAdapter(adapter);


    }

}