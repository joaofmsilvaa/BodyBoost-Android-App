package com.example.bodyboost.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bodyboost.R;
import com.example.bodyboost.models.Ingredients;
import com.example.bodyboost.models.IngredientsResponse;
import com.example.bodyboost.models.MealIngredients;
import com.example.bodyboost.models.MealIngredientsRepository;
import com.example.bodyboost.models.MealIngredientsResponse;
import com.example.bodyboost.models.MealResponse;
import com.example.bodyboost.models.Meals;
import com.example.bodyboost.models.retrofit.JsonPlaceHolderService;
import com.example.bodyboost.models.retrofit.RetrofitClient;
import com.example.bodyboost.viewmodels.IngredientsViewModel;
import com.example.bodyboost.viewmodels.MealIngredientsViewModel;
import com.example.bodyboost.viewmodels.MealsViewModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class nutricionFragment extends Fragment {

    private MealsAdapter adapter;

    private MealsViewModel viewModel;
    private IngredientsViewModel ingredientsViewModel;
    private MealIngredientsViewModel mealIngredientsViewModel;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(MealsViewModel.class);
        ingredientsViewModel = new ViewModelProvider(this).get(IngredientsViewModel.class);
        mealIngredientsViewModel = new ViewModelProvider(this).get(MealIngredientsViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nutricion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        RecyclerView recyclerView = view.findViewById(R.id.mealsRecyclerVIEW);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        viewModel.fetchMeals(getContext());

        viewModel.getMeals().observe(getViewLifecycleOwner(), meals -> {

            adapter = new MealsAdapter(meals);
            recyclerView.setAdapter(adapter);
        });

    }
}